/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Componentes_Jugador.Nave;
import Componentes_Jugador.Bullet;
import Hileras.Basic_Line;
import Ventanas.Gestor2;
import java.awt.*;

/**
 *
 * @author Daniel Camacho 
 * 
 */
public class GameManager 
{
    private Gestor2 gestor;
    private Nave nave;
    private Bullet bala;
    
    
    
    public GameManager()
    {
        
    }
    public GameManager(Gestor2 gest,Bullet bala,Nave nave)
    {
        this.gestor=gest;
        this.nave=nave;
        this.bala=bala;
        
    }
    public void render(Graphics g)
    {
        System.out.println("Drawing");
        try{
            gestor.getGame().getLManager().getCurrent().Render(g,gestor.getGame().getCanvas());
        }catch(Exception e){
            //render(g);
        }
        try
        {
            if (gestor.getGame().getCond()==false)
            {
            nave.render(g);
            }
            else
            {
            System.out.println("Shooting");
            nave.render(g);
            bala.Render(g);
            }
        }
        catch(Exception e)
        {
            
        }
        
    }
    public Nave getNav()
    {
        return nave;
    }
   public Bullet getBull()
   {
       return bala;
   }
  
   
}
