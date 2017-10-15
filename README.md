## euler - my [Project Euler][1] solutions

![Project Euler Badge](http://i.imgur.com/8qsRbxN.png "Project Euler Badge")

Running times on a mid-2012 MacBook Pro (2.7 GHz i7, 16 GB RAM, 10.12.2):

```
// Answers omitted to avoid spoiler alerts.
Problem097: XXX in 7904 ms
Problem067: XXX in 10 ms
Problem055: XXX in 242 ms
Problem052: XXX in 120 ms
Problem049: XXX in 64 ms
Problem048: XXX in 12 ms
Problem047: XXX in 7809 ms
Problem046: XXX in 1425 ms
Problem045: XXX in 113 ms
Problem043: XXX in 3319 ms
Problem042: XXX in 4 ms
Problem041: XXX in 294 ms
Problem040: XXX in 25 ms
Problem039: XXX in 7 ms
Problem038: XXX in 26 ms
Problem037: XXX in 651 ms
Problem036: XXX in 49 ms
Problem035: XXX in 654 ms
Problem034: XXX in 289 ms
Problem033: XXX in 5 ms
Problem032: XXX in 50 ms
Problem031: XXX in 18 ms
Problem030: XXX in 268 ms
Problem029: XXX in 45 ms
Problem028: XXX in 0 ms
Problem027: XXX in 245 ms
Problem026: XXX in 1 ms
Problem025: XXX in 110 ms
Problem024: XXX in 0 ms
Problem023: XXX in 176 ms
Problem022: XXX in 16 ms
Problem021: XXX in 26 ms
Problem020: XXX in 1 ms
Problem019: XXX in 4 ms
Problem018: XXX in 0 ms
Problem017: XXX in 0 ms
Problem016: XXX in 1 ms
Problem015: XXX in 0 ms
Problem014: XXX in 2372 ms
Problem013: XXX in 1 ms
Problem012: XXX in 605 ms
Problem011: XXX in 6 ms
Problem010: XXX in 960 ms
Problem009: XXX in 2 ms
Problem008: XXX in 0 ms
Problem007: XXX in 16 ms
Problem006: XXX in 0 ms
Problem005: XXX in 1 ms
Problem004: XXX in 8 ms
Problem003: XXX in 970 ms
Problem002: XXX in 0 ms
Problem001: XXX in 0 ms
```

### Adding a new solution
* Create a new class that inherits from Problem and implement abstract methods.
* In `Main.java` make sure `MAX_PROBLEM_ID` covers your problem id.
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
