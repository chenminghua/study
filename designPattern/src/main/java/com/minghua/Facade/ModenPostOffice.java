package com.minghua.Facade;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-9-17
 */
public class ModenPostOffice {
    private LetterProcess letterProcess = new LetterProcessImpl();
    private Police police = new Police();

    public void sendLetter(String context,  String address) {
        letterProcess.writeContext(context);
        letterProcess.fillEnvelope(address);
        police.check();
        letterProcess.letterInotoEnvelope();
        letterProcess.sendLetter();
    }

}
