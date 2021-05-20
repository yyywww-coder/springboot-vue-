package com.woniu.controller.managerController;

import com.woniu.domain.Perms;
import com.woniu.po.PermsPo;
import com.woniu.service.managerService.ManagerService;
import com.woniu.service.managerService.PermsService;
import com.woniu.utils.JwtTokenUtil;
import com.woniu.utils.ResponseResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("perms")
public class PermsController {

    @Autowired
    private PermsService permsService;
    @Autowired
    private ManagerService managerService;

    @RequestMapping("/menu")
    public ResponseResult<List<Perms>> findPermsByUsername(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        String userId = JwtTokenUtil.getUserId(token);
        List<Perms> perms = permsService.findPermByUsername(userId);
        List<Perms> firstNode = new ArrayList<>();
        for (Perms perm : perms) {
            if (perm.getLink() == null || perm.getLink().equals("")){
                firstNode.add(perm);
                //System.out.println(perm);
            }
        }

        List<Perms> menuPerm = new ArrayList<>();

        for (Perms perm : firstNode) {
            List<Perms> secondNode = new ArrayList<>();
            for (Perms item : perms) {
                if (item.getParentid() == perm.getId()){
                    secondNode.add(item);
                }
            }

            perm.setChildren(secondNode);
            menuPerm.add(perm);

        }
        return new ResponseResult<>(menuPerm);
    }


    @RequestMapping("/all")
    public ResponseResult<List<Perms>> findAllPerms(){
        List<PermsPo> list = permsService.findAllPerms();
        List<Perms> permsList = new ArrayList<>();

        for (PermsPo permsPo : list) {
            Perms item = new Perms();
            BeanUtils.copyProperties(permsPo,item);
            permsList.add(item);
        }
        //获取顶层节点
        List<Perms> rootNode = new ArrayList<>();
        for (Perms perms : permsList) {
            if (perms.getLink() == null){
                rootNode.add(perms);
            }
        }
        //循环顶层节点 找子节点
        for (Perms item : rootNode) {
            item.setChildren(getChildrenNode(item.getId(),permsList));
        }
        return new ResponseResult<>(rootNode);
}

    public List<Perms> getChildrenNode(Integer id,List<Perms> perms){
        //找某个子节点的子节点
        List<Perms> childList = new ArrayList<>();
        for (Perms item : perms) {
            if (item.getParentid() == id){
                childList.add(item);
            }
        }
        for (Perms item : childList) {
            item.setChildren(getChildrenNode(item.getId(),perms));
        }
        if (childList.size() == 0){
            return null;
        }
        return childList;
    }

    @RequestMapping("/add")
    public ResponseResult addRights(String keys,Integer id){
        permsService.delPermsById(id);

        String[] split = keys.split(",");
        for (int i = 0; i < split.length ; i++) {
            Map<String, Integer> maps = new HashMap<>();
            maps.put("managerId",id);
            maps.put("permsId",Integer.parseInt(split[i]));
            permsService.addPerms(maps,id);
        }

        return ResponseResult.SUCCESS;
    }


    /**
     * 返回该用户的所有最低级的功能id
     * @param id
     * @return
     */
    @RequestMapping("/perm")
    public ResponseResult<List<Integer>> findPermId(Integer id) {
        List<Perms> perms = permsService.getById(id);
        boolean flag = true;
        List<Integer> basePermId = new ArrayList<>();
        for (Perms perm : perms) {
            for (Perms permX : perms) {
                if (permX.getParentid() == perm.getId()) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                basePermId.add(perm.getId());
            }
            flag = true;
        }
        return new ResponseResult<>(basePermId);
    }

}
