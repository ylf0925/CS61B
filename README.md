# CS61B
Homeworks and Projects for CS61B Data Structures @ UCB

Original page : https://sp19.datastructur.es/index.html

Instructor: Josh Hug

## Proj0
To make autograde(18sp open to public) well functional, you **MUST** rename **Body.java** to **Planet.java**.

## Lab5
Do **NOT** set energy to zero if clorus has negative energy.  Otherwise clours are **immortal**.
Also, uncomment line 135 to 137 to correctly generate clorus!

## HW1
If you accidentally use keyword **Objects** when instantiate new generic array,   you got a  _java.lang.ArrayStoreException_ error, which can be quite annoyning.

This is **WRONG**:

```java
gAry = (T[ ]) new Objects[capacity]
```
Quite hard to find the bug, you should use **Object** to instantiate new generic array :
```java
gAry = (T[ ]) new Object[capacity]
```

