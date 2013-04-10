class Game(object):
    def __init__(self):
        self.rolls = []

    def roll(self, pins):
        self.rolls.append(pins)

    def score(self):
        score = 0
        i = 0
        for frame in range(10):
            if (self.rolls[i] + self.rolls[i+1]) == 10:
                # a spare has been rolled
                score += 10 + self.rolls[i+2]
            else:
                score += self.rolls[i] + self.rolls[i+1]
            i += 2
        return score


