package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.OccupiedCellException;
import ru.job4j.chess.firuges.Cell;

import static org.junit.Assert.*;

import java.util.Arrays;

public class BishopBlackTest extends TestCase {

    @Test
    public void testPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C5);
        Cell expected = Cell.C5;
        Cell rsl = bishopBlack.position();
        assertEquals(expected, rsl);
    }

    @Test
    public void testCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        BishopBlack newBishopBlack = (BishopBlack) bishopBlack.copy(Cell.A2);
        Cell expected = Cell.A2;
        Cell rsl = newBishopBlack.position();
        assertEquals(expected, rsl);
    }

    @Test
    public void testWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        Cell[] result = bishopBlack.way(Cell.G7);
        Cell[] expected = {Cell.E5, Cell.F6, Cell.G7};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testWayLong() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F2);
        Cell[] result = bishopBlack.way(Cell.A7);
        Cell[] expected = {Cell.E3, Cell.D4, Cell.C5, Cell.B6, Cell.A7};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testWayEx() throws ImpossibleMoveException {
        BishopBlack bishopBlack = new BishopBlack(Cell.C3);
        try {
            bishopBlack.way(Cell.E7);
            Assert.fail("Expected ImpossibleMoveException");
        } catch (ImpossibleMoveException ex) {
            Assert.assertNotEquals("", ex.getMessage());
        }
    }
}