import org.junit.Assert;
import org.junit.Test;

public class Tests {


        @org.junit.Test
        public void PrintToArray(){
            //Assign
            Game game = new Game();
            //Act
            char[] ch =  game.convertToCharArray("Mania");
            //Assert
            Assert.assertEquals(ch[0], 'M');
            Assert.assertEquals(ch[1], 'a');
            Assert.assertEquals(ch[2], 'n');
            Assert.assertEquals(ch[3], 'i');
            Assert.assertEquals(ch[4], 'a');


        }





}
