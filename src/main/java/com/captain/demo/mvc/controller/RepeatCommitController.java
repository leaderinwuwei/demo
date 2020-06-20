package com.captain.demo.mvc.controller;

import com.captain.demo.common.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import static java.lang.System.out;

/**
 * 重复提交导致多个相同数据
 *
 * @author Captain Wang
 * @time2020/4/15
 */
@RestController
public class RepeatCommitController {
    /**
     * 重复提交原因有很多，但是最终的结果就是我们此次请求的非幂等操作出现我们不希望看到的结果
     * servlet共享此全局变量
     */
    public List<Integer> list = new ArrayList<>();

    @GetMapping("/repeatCommit")
    public Result<List<Integer>> repeatCommit(Integer code) throws InterruptedException {
        out.println("servlet start");
        Result<List<Integer>> result = new Result<>();
        list.add(code);
        //模拟数据库内存占满，没有及时处理
        Thread.sleep(1000L);
        for (Integer integer : list) {
            out.print(integer + "\n");
        }
        result.setData(list);
        out.println("servlet end");
        return result;
    }

    @GetMapping("/clearList")
    public Result clearList(Integer code) {
        Result result = new Result();
        list = new ArrayList<>();
        return result;
    }

}
