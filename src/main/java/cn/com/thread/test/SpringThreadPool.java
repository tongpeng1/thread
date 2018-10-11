package cn.com.thread.test;

import cn.com.thread.util.RunnableUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SpringThreadPool {

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @RequestMapping("/springbootThreaPool")
    public void task(){
        for(int i = 0; i < 900000; i++){
            taskExecutor.execute(new RunnableUtil(i));
        }
    }

}
