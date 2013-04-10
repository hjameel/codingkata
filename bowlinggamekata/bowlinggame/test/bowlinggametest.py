import os.path
import sys
import unittest

# Add project root to module search path
project_root = os.path.join(os.path.abspath(os.path.dirname(__file__)), "..")
sys.path.insert(0, project_root)

from bowlinggame import Game

class BowlingGameTest(unittest.TestCase):
    def test_gutter_game(self):
        g = Game()
        for i in range(20):
            g.roll(0);
        self.assertEquals(0, g.score())

    def test_all_ones(self):
        g = Game()
        for i in range(20):
            g.roll(1)
        self.assertEquals(20, g.score())

if __name__ == "__main__":
    unittest.main()
