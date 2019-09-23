/**
 * PROBLEM 6.1 : The Heavy Pill
 * 
 * You have 20 bottles of pills. 19 bottles have 1.0 gram pills, but one
 * has pills of weight 1.1 grams. Given a scale that provides an exact measurement,
 * how would you find the heavy bottle ? You can only use the scale once.
 */

/**
 * SOLUTION :
 * 
 * To solve this, we take a pill from bottle one, two pills from bottle two and so on the
 * 20th bottle.
 * Then if all the bottle would have contained pills of 1.0 gram, then the displayed weight would be :
 * 1*1.0 + 2*1.0 + 3*1.0 + ... + 19*1.0 + 20*1.0 = 210 grams = M
 * However we know that one of the pills heap contains 1.1 grams pills, so we the total weight if it is
 * the first heap :
 *      - the first heap (1 pill) = M + 0.1
 *      - the second heap (2 pills) = M + 0.2
 *         ...
 *      - the twentieth heap (20 pills) = M + 2.0
 * According the displayed weight we can directly deduce which heap contains 1.1 grams pills and the
 * associated bottle with the formula : (weight - M) / 0.1
 */