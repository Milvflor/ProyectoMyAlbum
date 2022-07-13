/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author milel
 */
public class MiObjectOutputStream extends ObjectOutputStream{

    @Override
    protected void writeStreamHeader() throws IOException {
//        super.writeStreamHeader(); //To change body of generated methods, choose Tools | Templates.
    }

    public MiObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }
    
    
    
    
    
}
