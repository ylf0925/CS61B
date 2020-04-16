package creatures;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.awt.Color;

import huglife.Direction;
import huglife.Action;
import huglife.Occupant;
import huglife.Impassible;
import huglife.Empty;

public class TestClorus {

    @Test
    public void testBasics() {
        Clorus c = new Clorus(2);
        assertEquals(2, c.energy(), 0.01);
        assertEquals(new Color(34, 0, 231), c.color());
        c.move();
        assertEquals(1.97, c.energy(), 0.01);
        c.move();
        assertEquals(1.94, c.energy(), 0.01);
        c.stay();
        assertEquals(1.93, c.energy(), 0.01);
        c.stay();
        assertEquals(1.92, c.energy(), 0.01);
    }

    @Test
    public void testReplicate() {
        Clorus c = new Clorus();
        assertEquals(c.replicate().energy(), c.energy(), 0.01);
    }

    @Test
    public void testChoose() {

        // No empty adjacent spaces; stay.
        Clorus c = new Clorus(1);
        HashMap<Direction, Occupant> surrounded = new HashMap<Direction, Occupant>();
        surrounded.put(Direction.TOP, new Impassible());
        surrounded.put(Direction.BOTTOM, new Impassible());
        surrounded.put(Direction.LEFT, new Impassible());
        surrounded.put(Direction.RIGHT, new Impassible());
        Action actual = c.chooseAction(surrounded);
        Action expected = new Action(Action.ActionType.STAY);
        assertEquals(expected, actual);


        // any Plip occurred, Attack.
        c = new Clorus(1);
        HashMap<Direction, Occupant> leftPlip = new HashMap<Direction, Occupant>();
        leftPlip.put(Direction.TOP, new Impassible());
        leftPlip.put(Direction.BOTTOM, new Impassible());
        leftPlip.put(Direction.LEFT, new Plip());
        leftPlip.put(Direction.RIGHT, new Impassible());
        actual = c.chooseAction(leftPlip);
        expected = new Action(Action.ActionType.ATTACK, Direction.LEFT);
        assertEquals(expected, actual);

        // Energy >= 1; replicate towards an empty space.
        c = new Clorus(1);
        HashMap<Direction, Occupant> map1 = new HashMap<Direction, Occupant>();
        map1.put(Direction.TOP, new Impassible());
        map1.put(Direction.BOTTOM, new Impassible());
        map1.put(Direction.LEFT, new Impassible());
        map1.put(Direction.RIGHT, new Empty());
        actual = c.chooseAction(map1);
        expected = new Action(Action.ActionType.REPLICATE, Direction.RIGHT);
        assertEquals(expected, actual);


        c = new Clorus(0.1);
        HashMap<Direction, Occupant> map2 = new HashMap<Direction, Occupant>();
        map2.put(Direction.TOP, new Impassible());
        map2.put(Direction.BOTTOM, new Impassible());
        map2.put(Direction.LEFT, new Impassible());
        map2.put(Direction.RIGHT, new Empty());
        actual = c.chooseAction(map2);
        expected = new Action(Action.ActionType.MOVE, Direction.RIGHT);
        assertEquals(expected, actual);
    }

}
