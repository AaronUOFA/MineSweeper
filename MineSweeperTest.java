/**
 * The beginning of a unit test for MineSweeper.  
 */
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MineSweeperTest {

	@Test
	public void testGetAdjacentMinesWithAGivenTwodArrayOfBooleans() {

		boolean[][] b1 =

			{ { false, false, false, false, false },
				{ false, false, true, true, false },
				{ false, false, false, true, false }, };

		// Use the non-random constructor when testing to avoid random mine
		// placement.
		MineSweeper ms = new MineSweeper(b1);
		System.out.print(ms.toString());
		// Check adjacent mines around every possible GameSquare
		assertEquals(0, ms.getAdjacentMines(0, 0));
		assertEquals(1, ms.getAdjacentMines(0, 1));
		assertEquals(2, ms.getAdjacentMines(0, 2));
		assertEquals(2, ms.getAdjacentMines(0, 3));
		assertEquals(1, ms.getAdjacentMines(0, 4));

		assertEquals(0, ms.getAdjacentMines(1, 0));
		assertEquals(1, ms.getAdjacentMines(1, 1));
		assertEquals(2, ms.getAdjacentMines(1, 2)); // works even if it is a
		// mine
		assertEquals(2, ms.getAdjacentMines(1, 3));
		assertEquals(2, ms.getAdjacentMines(1, 4));

		assertEquals(0, ms.getAdjacentMines(2, 0));
		assertEquals(1, ms.getAdjacentMines(2, 1));
		assertEquals(3, ms.getAdjacentMines(2, 2));
		assertEquals(2, ms.getAdjacentMines(2, 3));
		assertEquals(2, ms.getAdjacentMines(2, 4));
		//

		assertEquals(3, ms.getTotalMineCount());

	}

	@Test
	public void testSecondConstructor() {
		MineSweeper ms = new MineSweeper(10, 10, 5);

		assertEquals(5, ms.getTotalMineCount());
		System.out.println(ms.toString());
		System.out.print(ms.toString());
	}

	@Test
	public void testSecondConstructor2() {
		MineSweeper ms = new MineSweeper(10, 10, 0);

		assertEquals(0, ms.getTotalMineCount());
		System.out.println(ms.toString());
		System.out.print(ms.toString());
	}

	@Test
	public void testSecondConstructor3() {
		MineSweeper ms = new MineSweeper(10, 10, 100);

		assertEquals(100, ms.getTotalMineCount());
		System.out.println(ms.toString());
		System.out.print(ms.toString());
	}

	@Test
	public void testisFlagged() {
		boolean[][] b1 =

			{ { false, false, false, false, false },
				{ false, false, true, true, false },
				{ false, false, false, true, false }, };

		MineSweeper ms = new MineSweeper(b1);

		ms.toggleFlagged(1, 1);

		assertEquals(true, ms.isFlagged(1, 1));
		ms.toggleFlagged(1, 1);
		assertEquals(false, ms.isFlagged(1, 1));
	}

	@Test
	public void testisVisible() {
		boolean[][] b1 =

			{ { false, false, false, false, false },
				{ false, false, true, true, false },
				{ false, false, false, true, false }, };

		MineSweeper ms = new MineSweeper(b1);

		assertEquals(false, ms.isVisible(1, 1));
		ms.click(1, 1);
		assertEquals(true, ms.isVisible(1, 1));
	}

	@Test
	public void testLost() {
		boolean[][] b1 =

			{ { false, false, false, false, false },
				{ false, false, true, true, false },
				{ false, false, false, true, false }, };

		MineSweeper ms = new MineSweeper(b1);
		ms.click(1, 2);
		assertEquals(true, ms.lost());
	}

	@Test
	public void testWon() {
		boolean[][] b1 =

			{ { false, false, false, false, false }, };

		MineSweeper ms = new MineSweeper(b1);
		ms.click(0, 0);
		ms.click(0, 1);
		ms.click(0, 2);
		ms.click(0, 3);
		ms.click(0, 4);

		assertEquals(false, ms.lost());
		assertEquals(true, ms.won());
	}

	@Test
	public void testWon2() {
		boolean[][] b1 =

			{ { false, true, false, false, false }, };

		MineSweeper ms = new MineSweeper(b1);

		ms.click(0, 1);
		ms.click(0, 2);
		ms.click(0, 3);
		ms.click(0, 4);

		assertEquals(true, ms.lost());
		assertEquals(false, ms.won());
	}

	@Test
	public void testWon5() {
		boolean[][] b1 =

			{ { false, false, false, false, false }, };

		MineSweeper ms = new MineSweeper(b1);

		ms.click(0, 2);
		ms.click(0, 3);
		ms.click(0, 4);

		assertEquals(true, ms.won());
	}

	@Test
	public void testWon3() {
		boolean[][] b1 =

			{ { true, false, false, false, false },
				{ false, false, false, false, false } };

		MineSweeper ms = new MineSweeper(b1);

		ms.click(0, 2);
		ms.click(1, 1);
		ms.click(1, 4);

		assertEquals(false, ms.won());
	}

	@Test
	public void testWonFINAL() {
		boolean[][] b1 =

			{ { true, false, false, false, false },
				{ false, false, false, false, false } };

		MineSweeper ms = new MineSweeper(b1);
		ms.toggleFlagged(0, 0);
		ms.click(0, 0);
		ms.click(0, 1);
		ms.click(0, 2);
		ms.click(0, 3);
		ms.click(0, 4);
		ms.click(1, 1);
		ms.click(1, 0);
		ms.click(1, 4);

		assertEquals(true, ms.won());
	}

}