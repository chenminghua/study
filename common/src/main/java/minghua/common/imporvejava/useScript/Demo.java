package minghua.common.imporvejava.useScript;

import org.junit.Test;

import javax.script.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Demo {
    @Test
    public void javaCallScript() throws FileNotFoundException, ScriptException, NoSuchMethodException {
        //获取一个javascript的执行引擎
        String scriptType = "javascript";
        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName(scriptType);
        //绑定上下文
        Bindings bindings = scriptEngine.createBindings();
        bindings.put("factor", 1);
        //绑定上下文，作用域是当前引擎范围
        scriptEngine.setBindings(bindings, ScriptContext.ENGINE_SCOPE);
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int first = input.nextInt();
            int sec = input.nextInt();
            System.out.println("输入参数是：" + first + "," + sec);
            //执行js代码
            scriptEngine.eval(new FileReader("d:/ramq.domain.js"));
            //是否可调用方法
            if (scriptEngine instanceof Invocable) {
                Invocable in = (Invocable) scriptEngine;
                //执行js中的函数
                Double result = (Double) in.invokeFunction("formula", first, sec);
                System.out.println("运算结果是：" + result.intValue());
            }
        }
    }
}
