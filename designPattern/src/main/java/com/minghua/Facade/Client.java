package com.minghua.Facade;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-9-17
 */
public class Client {
    public static void main(String[] args) {

        /*
        this is what I do
         */
        //创建一个处理信件的过程
        LetterProcess letterProcess = new LetterProcessImpl();
        //开始写信
        letterProcess.writeContext("Hello,It's me,do you know who I am? I'm your old lover. I'd like to....");
        //开始写信封
        letterProcess.fillEnvelope("Happy Road No. 666,God Province,Heaven");
        //把信放到信封里，并封装好
        letterProcess.letterInotoEnvelope();
        //跑到邮局把信塞到邮箱，投递
        letterProcess.sendLetter();


        /*
        in facade
         */
        //你只要把信的内容和收信人地址给他，他会帮你完成一系列的工作；
        String address = "Happy Road No. 666,God Province,Heaven"; //定义一个地址
        String context = "Hello,It's me,do you know who I am? I'm your old lover. I'd like to....";
        ModenPostOffice modenPostOffice = new ModenPostOffice();
        modenPostOffice.sendLetter(context, address);

        /*
        add police check letter
         */
        ModenPostOffice modenPostOfficeUnderCheck = new ModenPostOffice();
        modenPostOffice.sendLetter(context, address);
    }

}
