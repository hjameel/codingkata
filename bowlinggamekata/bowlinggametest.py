import unittest

from bowlinggame import Game

class BowlingGameTest(unittest.TestCase):
    def setUp(self):
        self.g = Game()

    def _roll_many(self, n, pins):
        for i in range(n):
            self.g.roll(pins);

    def test_gutter_game(self):
        self._roll_many(20, 0)
        self.assertEquals(0, self.g.score())

    def test_all_ones(self):
        self._roll_many(20, 1)
        self.assertEquals(20, self.g.score())

    def test_one_spare(self):
        self._roll_spare()
        self.g.roll(3)
        self._roll_many(17, 0)

        self.assertEquals(16, self.g.score())

    def test_one_strike(self):
        self.g.roll(10)
        self.g.roll(3)
        self.g.roll(4)
        self._roll_many(16, 0)
        self.assertEquals(24, self.g.score())

    def _roll_spare(self):
        self.g.roll(5)
        self.g.roll(5)


if __name__ == "__main__":
    unittest.main()
