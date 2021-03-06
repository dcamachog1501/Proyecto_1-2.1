/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;
import Componentes_Jugador.Nave;
import Componentes_Jugador.Player;
import Manager.LevelManager;
import Threads.Setup;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel Camacho
 */
public class Gestor2
{
    
  //Elementos necesarios para el desrrollo de ventanas
  private  final String Titulo="Invaders";
  private  final Image Icono=Toolkit.getDefaultToolkit().getImage("Resources/Iconos/Icono.png");
  private  Font FuenteTitulo;
  private  Font FuenteMarc;
  private final  Color Btn=new Color(75,0,130);
  private final Image Back=Toolkit.getDefaultToolkit().getImage("Resources/Backgrounds/Background.jpg");
  private Image Back2= Toolkit.getDefaultToolkit().getImage("Resources/Backgrounds/Back2.png");
  
  //Creacion de las ventanas de la interfaz 
  private Ventana_Inicial VentanaInicial;
  private Ventana_Estadisticas VentanaStatics;
  private  Ventana_Datos VentanaDatos;
  private  Ventana_Juego VentanaJuego;
  private Ventana_Final VentanaFinal;
  private Setup s;
  private Nave n;
  private LevelManager LManager;
    public Gestor2()
    {
      try
      {
          //Fuente principal de la interfaz
          FuenteTitulo= Font.createFont(Font.TRUETYPE_FONT, new File("Resources/Fuentes/Furore.ttf"));
      }
      catch(Exception e)
      {
          FuenteTitulo=null;
      }
        
      try
      {
          //Fuente del marcador
        FuenteMarc= Font.createFont(Font.TRUETYPE_FONT, new File("Resources/Fuentes/Marcador.ttf"));  
      }
      catch(Exception e)
      {
         FuenteMarc=null; 
      }
    }
    /**
     * Método encargado de desplegar la ventana inicial en panatalla.
     */
    public void gestInicial()
    {
      VentanaInicial.setVisible(true);
    }
    /**
     * Método wue permite desplegar la ventana de estadisticas
     */
    public void gestStatics()
    {
        VentanaStatics.setVisible(true);
    }
    /**
     * Metodo que permite la proyeccion de la ventana de toma de datos.
     */
    public void gestDatos()
    {
       VentanaDatos.setVisible(true);
    }
    /**
     * Metodo que permite desplegar la ventana del juego.
     */
    public void gestJuego()
    {
       VentanaJuego.setVisible(true);
    }
    public void gestFinal()
    {
        VentanaFinal.setVisible(true);
    }
    public void Init()
    {
        this.LManager=new LevelManager(this);
        this.n= new Nave(this);
        this.s= new Setup(this,n);
        VentanaInicial=new Ventana_Inicial(Titulo,FuenteTitulo,Back,Icono,Btn, this);
      try {
          VentanaStatics=new Ventana_Estadisticas(Titulo,FuenteTitulo,Back,Icono,Btn,Back2,this);
      } catch (IOException ex) {
          Logger.getLogger(Gestor2.class.getName()).log(Level.SEVERE, null, ex);
      }
        VentanaDatos=new Ventana_Datos(Titulo,FuenteTitulo,Back,Icono,Btn,this,s);
        VentanaJuego=new Ventana_Juego(Titulo,FuenteTitulo,Icono,Btn,FuenteMarc,this,LManager,s);
        VentanaFinal= new Ventana_Final(Titulo,FuenteTitulo,Back,Icono,Btn, this);
    }
    /**
     * Metodo para obtener la instancia de VentanaJuego
     * @return objeto de tipo Ventana_Juego
     */
    public Ventana_Juego getGame()
    {
        return VentanaJuego;
    }
    /**
     * Metodo para obtener la instancia de VentanaDatos
     * @return onjeto de tipo Ventana_Datos
     */
    public Ventana_Datos getDatos()
    {
        return VentanaDatos;
    }
    public LevelManager getLManager()
    {
        return LManager;
    }
    public void endGame()
    {
     Player p= new Player();
     p.Init(VentanaDatos.getPlayerNam(),VentanaJuego.getMarc());
     VentanaStatics.saveMarc(p);
     VentanaFinal.setMarc(VentanaJuego.getMarc());
     VentanaJuego.stopExcecution();
     VentanaJuego.dispose();
     VentanaDatos=null;
     VentanaJuego=null;
     gestFinal();
     System.out.println("------------------GAME_OVER------------------");
    }
}
