package ru.job4j.chess;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.FigureNotFoundException;
import ru.job4j.chess.OccupiedCellException;

import static org.junit.Assert.*;

public class LogicTest {

    @Test
    public void whenMoveWithoutEx()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);
        int number = logic.findBy(Cell.H6);
        assertEquals(0, number);
    }

    @Test
    public void whenMoveWithFigureNotFoundEx()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        try {
            logic.move(Cell.C2, Cell.D3);
            Assert.fail("FigureNotFoundException expected");
        } catch (FigureNotFoundException ex) {
            Assert.assertNotEquals("", ex.getMessage());
        }
    }

    @Test
    public void whenMoveWithOccupiedCellEx() throws
            FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.E3));
        try {
            logic.move(Cell.C1, Cell.H6);
            Assert.fail("OccupiedCellException expected");
        } catch (OccupiedCellException ex) {
            Assert.assertNotEquals("", ex.getMessage());
        }
    }

    @Test
    public void whenMoveWithImpossibleMoveEx() throws
            FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        try {
            logic.move(Cell.C1, Cell.E4);
            Assert.fail("ImpossibleMoveException expected");
        } catch (ImpossibleMoveException ex) {
            Assert.assertNotEquals("", ex.getMessage());
        }
    }
}