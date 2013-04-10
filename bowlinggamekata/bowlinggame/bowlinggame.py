class Game(object):
    def __init__(self):
        self.score_counter = 0

    def roll(self, pins):
        self.score_counter += pins

    def score(self):
        return self.score_counter
