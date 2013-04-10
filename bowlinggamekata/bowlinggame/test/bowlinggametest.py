import os.path
import sys
import unittest

# Add project root to module search path
project_root = os.path.join(os.path.abspath(os.path.dirname(__file__)), "..")
sys.path.insert(0, project_root)

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


if __name__ == "__main__":
    unittest.main()
