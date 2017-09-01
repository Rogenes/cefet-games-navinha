package br.cefetmg.games.collision;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Utilitário para verificação de colisão.
 *
 * @author fegemo <coutinho@decom.cefetmg.br>
 */
public class Collision {

    /**
     * Verifica se dois círculos em 2D estão colidindo.
     * @param c1 círculo 1
     * @param c2 círculo 2
     * @return true se há colisão ou false, do contrário.
     */
    public static final boolean circlesOverlap(Circle c1, Circle c2) {
        
        Vector2 centro1 = new Vector2(c1.x,c1.y);
        Vector2 centro2 = new Vector2(c2.x,c2.y);
        
        return (((c1.radius+c2.radius)*(c1.radius+c2.radius))>(centro1.dst2(centro2)));
        }

    /**
     * Verifica se dois retângulos em 2D estão colidindo.
     * Esta função pode verificar se o eixo X dos dois objetos está colidindo
     * e então se o mesmo ocorre com o eixo Y.
     * @param r1 retângulo 1
     * @param r2 retângulo 2
     * @return true se há colisão ou false, do contrário.
     */
   
    public static final boolean rectsOverlap(Rectangle r1, Rectangle r2) {
        if(r2.x<r1.x+r1.width && r2.x+r2.width>r1.x){
            if(r2.y<r1.y+r1.height && r2.y+r2.height>r1.y){
                return true;
            }
        }
        
        return false;
    }
    
    public static final boolean circlesVsRectangles(Rectangle r, Circle c){
        
        Vector2 c1 = new Vector2(c.x,c.y);
        Vector2 r1 = new Vector2(r.x+r.width/2,r.y+r.height/2);
        Vector2 distancia = new Vector2(c1.x-r1.x,c1.y-r1.y);
        Vector2 projecaox = new Vector2(distancia.x,r1.y); 
        Vector2 projecaoy = new Vector2(r1.x,distancia.y);
        
       
        if(projecaox.len()>r.width/2){
            projecaox.nor();
            projecaox.scl(r.width/2);
            
        }
        
        if(projecaoy.len()>r.height/2){
            projecaoy.nor();
            projecaoy.scl(r.height/2);
        }
        
        Vector2 p = new Vector2(projecaox.x,projecaoy.y); 
      
        return (c.radius >= p.dst(c1));
        
    
    }
    
}
