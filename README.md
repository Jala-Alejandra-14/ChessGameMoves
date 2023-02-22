# Chess Game Moves

### General Features
- The pieces are composed of "Pawn", "Knight", "Bishop", "Rook", "Queen" and "King".
  - For the moment it does not matter whether they belong to the white or black boxes.
  
### How to use
- The chess piece must be entered.
- Select the box where it is located
  - Considering that the rows are from A-H and the columns from 1-8
  
| A8 | B8 | C8 | D8 | E8 | F8 | G8 | H8 |
| ----------- | ----------- |---------- | --------- | --------- |--------- |--------- |--------- |
| A7 | B7 | C7 | D7 | E7 | F7 | G7 | H7 |
| A6 | B6 | C6 | D6 | E6 | F6 | G6 | H6 |
| A5 | B5 | C5 | D5 | E5 | F5 | G5 | H5 |
| A4 | B4 | C4 | D4 | E4 | F4 | G4 | H4 |
| A3 | B3 | C3 | D3 | E3 | F3 | G3 | H3 |
| A2 | B2 | C2 | D2 | E2 | F2 | G2 | H2 |
| A1 | B1 | C1 | D1 | E1 | F1 | G1 | H1 |

- The box where it could be moved is added
- Finally, the system returns TRUE if it can be moved or FALSE if it is not allowed for that piece.

### Example
- "Rook", "A8", "H8" ➞ true
- "Bishop", "A7", "G1" ➞ true
- "Queen", "C4", "D6" ➞ false
