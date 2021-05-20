package com.woniu.controller.managerController;

import com.woniu.domain.PaperManage;
import com.woniu.service.managerService.FillQuestionService;
import com.woniu.service.managerService.JudgeQuestionService;
import com.woniu.service.managerService.MultiQuestionService;
import com.woniu.service.managerService.PaperManagerService;
import com.woniu.utils.ResponseResult;
import com.woniu.vo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("addQuestion")
public class ItemController {

    @Autowired
    MultiQuestionService multiQuestionService;

    @Autowired
    FillQuestionService fillQuestionService;

    @Autowired
    JudgeQuestionService judgeQuestionService;

    @Autowired
    PaperManagerService paperService;



    @PostMapping("/item")
    public ResponseResult ItemController(@RequestBody Item item) {
        // 选择题
        Integer changeNumber = item.getChangeNumber();
        // 填空题
        Integer fillNumber = item.getFillNumber();
        // 判断题
        Integer judgeNumber = item.getJudgeNumber();
        //出卷id
        Integer paperId = item.getPaperId();

        // 选择题数据库获取
        List<Integer>  changeNumbers = multiQuestionService.getAllSubject(item.getSubject(), changeNumber);
        if(changeNumbers==null){
            return new ResponseResult(400,"选择题数据库获取失败");
        }
        for (Integer number : changeNumbers) {
            PaperManage paperManage = new PaperManage(paperId,1,number);
            int index = paperService.add(paperManage);
            if(index==0)
                return new ResponseResult(400,"选择题组卷保存失败");
        }

        // 填空题
        List<Integer> fills = fillQuestionService.findBySubject(item.getSubject(), fillNumber);
        if(fills==null)
            return new ResponseResult(400,"填空题数据库获取失败");
        for (Integer fillNum : fills) {
            PaperManage paperManage = new PaperManage(paperId,2,fillNum);
            int index = paperService.add(paperManage);
            if(index==0)
                return new ResponseResult(400,"填空题题组卷保存失败");
        }
        // 判断题
        List<Integer> judges = judgeQuestionService.getBySubject(item.getSubject(), judgeNumber);
        if(fills==null)
            return new ResponseResult(400,"判断题数据库获取失败");
        for (Integer judge : judges) {
            PaperManage paperManage = new PaperManage(paperId,3,judge);
            int index = paperService.add(paperManage);
            if(index==0)
                return new ResponseResult(400,"判断题题组卷保存失败");
        }


          return ResponseResult.SUCCESS;
    }
}
