package creatures;

import huglife.*;

import java.awt.Color;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;


public class Clorus extends Creature {

    /**
     * red color.
     */
    private int r;

    /**
     * green color.
     */
    private int g;

    /**
     * blue color.
     */
    private int b;

    /**
     * creates clorus with energy equal to E.
     */
    public Clorus(double e) {
        super("clorus");
        r = 0;
        g = 0;
        b = 0;
        energy = e;
    }

    /**
     * creates a clorus with energy equal to 1.
     */
    public Clorus() {
        this(1);
    }

    @Override
    public Color color() {
        r = 34;
        b = 231;
        g = 0;
        return color(r, g, b);
    }

    @Override
    public void move() {
        energy -= 0.03;
    }

    @Override
    public void stay() {
        energy -= 0.01;
    }

    @Override
    public void attack(Creature c) {
        energy += c.energy();
    }

    @Override
    public Creature replicate() {
        double energyGivenProp = 0.5;
        double babyEnergy = energy * energyGivenProp;
        double energyRetainProp = 0.5;
        energy = energy * energyRetainProp;
        return new Clorus(babyEnergy);
    }


    @Override
    public Action chooseAction(Map<Direction, Occupant> neighbors) {

        // Scan perimeter phase
        Deque<Direction> emptyNeighbors = new ArrayDeque<>();
        Deque<Direction> targetNeighbors = new ArrayDeque<>();

        for (Direction key : neighbors.keySet()) {
            if (neighbors.get(key).name().equals("empty")) {
                emptyNeighbors.add(key);
            }
            if (neighbors.get(key).name().equals("plip")) {
                targetNeighbors.add(key);
            }

        }
        // Action phase
        if (emptyNeighbors.size() == 0 && targetNeighbors.size() == 0) {
            // Rule 1
            return new Action(Action.ActionType.STAY);
        } else if (targetNeighbors.size() != 0) {
            // Rule 2
            return new Action(Action.ActionType.ATTACK,
                    HugLifeUtils.randomEntry(targetNeighbors));
        } else if (energy >= 1) {
            // Rule 3
            return new Action(Action.ActionType.REPLICATE,
                    HugLifeUtils.randomEntry(emptyNeighbors));
        } else
            // Rule 4
            return new Action(Action.ActionType.MOVE,
                    HugLifeUtils.randomEntry(emptyNeighbors));
    }


}
