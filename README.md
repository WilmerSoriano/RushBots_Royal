# Rush Bot Royal

Rush Bot Royal is a simulation betting game where four bots compete to collect coins as fast as possible.  
Players bet on which bot they believe will win each round and earn (or lose) money based on the final rankings.

---

## Game Concept

Four bots start in the **four corners of the map**.

In the **center of the arena** there is a box containing coins.

Each bot will attempt to collect as many coins as possible as quickly as possible.

At the end of the round:

- The bot with the most coins wins
- The remaining bots are ranked based on coins collected

Players place bets on which bot they think will win.

---

## Starting Conditions

- The player starts with **$50**
- Before each round the player may choose how much money to bet
- The player selects which bot they think will win

---

## Payout System

After the round ends, payouts are determined by the position of the bot the player selected.

| Position | Payout |
|--------|--------|
| 1st place | 2× bet |
| 2nd place | 1× bet |
| 3rd place | 50% of bet returned |
| 4th place | -$40 penalty |

---

## Rounds

The game contains **100 rounds**.

Difficulty increases as the rounds progress.

Example progression:

| Rounds | Difficulty |
|------|------|
| 1 – 10 | Beginner |
| 11 – 20 | Intermediate |
| 21 – 45 | Advanced |
| 46 – 75 | Expert |
| 76 – 90 | Elite |
| 91 – 100 | Master |

Difficulty changes may affect:

- Bot movement speed
- Coin spawn rate
- Pathfinding difficulty
- Random events

*(Details still being designed)*

---

## Core Gameplay Loop

1. Player chooses a bot to bet on
2. Player selects bet amount
3. Round simulation starts
4. Bots race to collect coins
5. Final rankings are determined
6. Player receives payout
7. Next round begins

---

## Planned Features

- Bot AI with different behaviors
- Increasing difficulty levels
- Coin spawn mechanics
- Betting strategy element
- Visual arena simulation
- Round statistics

---

## Tech Stack (Planned)

- Java
- Java Swing (for GUI)
- Simulation-based game loop

---

## Project Status

🚧 Work in progress...

