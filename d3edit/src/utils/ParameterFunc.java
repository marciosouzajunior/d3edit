/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import org.fife.ui.autocomplete.ParameterizedCompletion;

public class ParameterFunc extends ParameterizedCompletion.Parameter{

    public ParameterFunc(Object o, String string) {
        super(o, string);
    }
    
    public ParameterFunc(String nome, String desc){
        super(null, nome);
        setDescription(desc);       
    }
    
    public ParameterFunc(String nome){
        super(null, nome);
    }    
    
}
