## euler - my [Project Euler][1] solutions

![Project Euler Badge](https://projecteuler.net/profile/markcerqueira.png "Project Euler Badge")

Output from running `Main.java` on a mid-2012 MacBook Pro (2.7 GHz i7, 16 GB RAM, 10.11.5):

```
// Answers omitted to avoid spoiler alerts.
Problem15: XX in 11 ms
Problem14: XX in 2626 ms
Problem13: XX in 7 ms
Problem12: XX in 733 ms
Problem11: XX in 9 ms
Problem10: XX in 1199 ms
Problem9: XXX in 3 ms
Problem8: XXX in 1 ms
Problem7: XXX in 20 ms
Problem6: XXX in 0 ms
Problem5: XXX in 1 ms
Problem4: XXX in 30 ms
Problem3: XXX in 1190 ms
Problem2: XXX in 1 ms
Problem1: XXX in 0 ms
```

To solve a new problem:
* Create a new class that inherits from Problem and implement abstract methods.
* Add the new class name (e.g. `Problem1.class`) to `problemClasses` in `Main.java`.
* The `public long solveProblem()` should return the answer to the problem.
* Running `Main.java` class solves all problems in the `problemClasses` array.
* Once the answer is correct [Base64 encode it][2] and return that value as a String in `public String base64EncodedAnswer()`.

[1]: https://projecteuler.net/
[2]: https://www.base64encode.org/
