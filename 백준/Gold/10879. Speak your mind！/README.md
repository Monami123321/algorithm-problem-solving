# [Gold III] Speak your mind! - 10879 

[문제 링크](https://www.acmicpc.net/problem/10879) 

### 성능 요약

메모리: 14032 KB, 시간: 132 ms

### 분류

데이크스트라, 다이나믹 프로그래밍, 그래프 이론, 최단 경로

### 제출 일자

2024년 5월 16일 23:06:04

### 문제 설명

<p>The Shakespeare Programming Language (SPL) is an esoteric programming language where the program code looks like Shakespearean plays. An example of a typical program written with SPL is as follows:</p>

<pre>The Infamous Hello World Program.

Romeo, a young man with a remarkable patience.
Juliet, a likewise young woman of remarkable grace.
Ophelia, a remarkable woman much in a dispute with Hamlet.
Hamlet, the flatterer of Andersen Insulting A/S.

Act I: Hamlet's insults and flattery.
Scene I: The insulting of Romeo.

[Enter Hamlet and Romeo]

Hamlet:
 You lying stupid fatherless big smelly half-witted coward!
 You are as stupid as the difference between a handsome rich brave
 hero and thyself! Speak your mind!
(The rest omitted)</pre>

<p>In SPL, numbers are expressed using nouns and adjectives. The positive noun has the value of 1, while the negative noun has the value of −1. Adjectives are used to double the value. Articles such as ‘a’, ‘an’, and ‘the’ may or may not be used.</p>

<pre>an angel = 1
curse = -1
a beautiful sweet rose = 2 * 2 * 1 = 4
dirty rotten dusty fat war = 2 * 2 * 2 * 2 * (-1) = -16</pre>

<p>To construct arbitrary integers other than the power of two, you can use basic arithmetic to make those integers. The expression “the sum of (A) and (B)” is used to get the value of A + B and “the difference between (A) and (B)” is used to get the value of A−B, where “(A)” and “(B)” represents numbers written in ‘Shakespearean’ form. No adjectives are allowed in these form (e.g. ‘the mighty sum of hero and king’ is invalid.) The other operations such as multiplication and division are also present in original SPL, but for the simplicity, we assume that only addition and subtraction are to be used in this problem.</p>

<pre>the sum of happy lovely honest golden mighty hero and bad smooth cunning pony
    = 2 * 2 * 2 * 2 * 2 * 1 + 2 * 2 * 2 * 1 = 40
the difference between gentle golden peaceful handsome charming happy King
    and the sum of bad hero and lying misused beggar
    = 2 * 2 * 2 * 2 * 2 * 2 * 1 - (2 * 1 + 2 * 2 * (-1)) = 66</pre>

<p>Bryan likes to make a program with SPL. However, he does not like verboseness in codes as other programmers. That is why he wants to find the expression where the number of words used is as small as possible. Write a program which calculates the minimum number of words to express in the Shakespearean form.</p>

### 입력 

 <p>The first line of the input contains one integer T (1 ≤ T ≤ 10, 000), the number of test cases. Each test case consists of one line, which contains one integer N (|N| ≤ 50, 000), which is the number to be expressed in the Shakespearean form.</p>

### 출력 

 <p>Print exactly one number for each test case, representing the minimum number of words.</p>

