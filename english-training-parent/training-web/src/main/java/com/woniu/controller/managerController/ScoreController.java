package com.woniu.controller.managerController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.domain.Score;
import com.woniu.po.ScorePo;
import com.woniu.service.managerService.ScoreService;
import com.woniu.utils.ResponseResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/score/")
public class ScoreController {

        @Autowired
        private ScoreService scoreService;

        /**
         * 分页分数
         * @return
         */
        @RequestMapping("getById")
        public ResponseResult<List<Score>> list(String studentId){
                List<ScorePo> scorePoList = scoreService.findById(studentId);
                List<Score> scoreList = new ArrayList<>();
                for (ScorePo scorePo : scorePoList) {
                        Score score = new Score();
                        BeanUtils.copyProperties(scorePo,score);
                        scoreList.add(score);

                }
                return new ResponseResult<>(scoreList);
        }

        /**
         * 修改分数
         * @return
         */
        @RequestMapping("update")
        public ResponseResult update(@RequestBody ScorePo scorePo){
                scoreService.update(scorePo);
                return ResponseResult.SUCCESS;
        }

        /**
         * 根据id删除
         * @param id
         * @return
         */
        @RequestMapping("delete")
        public ResponseResult delete(Integer id){
                scoreService.delete(id);
                return ResponseResult.SUCCESS;
        }

        /**
         * 新增分数
         * @return
         */
        @RequestMapping("add")
        public ResponseResult add(@RequestBody ScorePo scorePo){
                scoreService.add(scorePo);
                return ResponseResult.SUCCESS;
        }

        @RequestMapping("scores/{examCode}")
        public ResponseResult<List<Score>> findByCode(@PathVariable("examCode") Integer examCode){

                List<Score> scoreList = new ArrayList<>();
                List<ScorePo> scorePoList = scoreService.findByCode(examCode);
                for (ScorePo scorePo : scorePoList) {
                        Score score = new Score();
                        BeanUtils.copyProperties(scorePo,score);
                        scoreList.add(score);
                }
                return new ResponseResult<>(scoreList);

        }

}
