## euler - my [Project Euler][1] solutions

![Project Euler Badge](https://projecteuler.net/profile/markcerqueira.png "Project Euler Badge")

Output from running `Main.java` on a mid-2012 MacBook Pro (2.7 GHz i7, 16 GB RAM, 10.11.5):

```
// Answers omitted to avoid spoiler alerts.
Problem24: XX in 5 ms
Problem23: XX in 200 ms
Problem22: XX in 27 ms
Problem21: XX in 54 ms
Problem20: XX in 11 ms
Problem19: XX in 6 ms
Problem67: XX in 18 ms
Problem18: XX in 1 ms
Problem17: XX in 5 ms
Problem16: XX in 3 ms
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

### Adding a new solution
* Create a new class that inherits from Problem and implement abstract methods.
* Add the new class name (e.g. `Problem1.class`) to `problemClasses` in `Main.java`.
* The `public long solveProblem()` should return the answer to the problem. Solutions should follow Project Euler's ["one-minute rule"][3]: most solutions should run under one minute. 
* Running `Main.java` class solves all problems in the `problemClasses` array.
* Once the answer is correct [Base64 encode it][2] and return that value as a String in `public String base64EncodedAnswer()`. When the problem is solved on subsequent runs it'll verify that the answer it calculates is still correct.

### Improvements
* Some (cheeky) solutions use `BigInteger` to work with super big numbers. For increased challenge, reduce usage of BigInteger as much as possible.
* Lots of solutions are brute force (but run very quickly). Explore if there are more elegant solutions. 
* Add problem metadata (e.g. title) to Problem subclasses.

[1]: https://projecteuler.net/
[2]: https://www.base64encode.org/
[3]: https://projecteuler.net/about
