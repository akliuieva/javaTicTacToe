# TicTacToeWithAI

## Rules of TicTacToe with AI:
You can play in TicTacToe by two type of player on 3x3 playing table.

### Types of players are:<br>

1. #### User <br>
    Description:<br>
Make it's own steps by entering coordinates of the playing table.<br>
Now the coordinates start from the upper left corner.<br><br>

    Example:<br>

    Enter the coordinates: > 1 1 <br>
 ```  
    --------- 
    |X     | 
    |      | 
    |      |
    --------- 
 ```   

2. #### Computer:

Computer player have three difficulty levels: <br>
* **easy** <br>
  _Description_:<br>
The computer just makes random moves

* **medium** <br>
  _Description_:<br>
When the AI is playing at medium difficulty level, it makes moves using the following logic:<br>

    If it already has two in a row and can win with one further move, it does so.<br>
If its opponent can win with one move, it plays the move necessary to block this.<br>
Otherwise, it makes a random move.

* **hard** <br>
  _Description:_<br>
  Computer player calculates all possible moves that might be played during the game, and choose the best one based on the assumption that its opponent will also play perfectly. To nake it happen the minimax algorythm is used


### To start playing in TicTacToe:<br>
Run Main.class -> enter command <br>
```
start firstPlayer secondPlayer
```

Example:<br>
```
start user hard
```

where **firstPlayer** and **secondPlayer** have be replaced with **user** or **easy** or **medium** or **hard**<br>

For more information please follow the link:
https://hyperskill.org/projects/81
