# Low-Level Design: Builder Pattern in a Threaded Environment

This document outlines the solution to implementing the **Builder Pattern** in a threaded environment. The solution has been implemented using two approaches to ensure thread safety.

## Problem Statement
Design and implement a **Product** class and a corresponding builder pattern that can be safely used in a **multi-threaded environment**.

## Solution Approaches

### 1. **Using `synchronized`**
- Leveraged Java's built-in `synchronized` keyword to ensure thread safety while building the `Product` object.
- Each method in the builder class is synchronized, preventing multiple threads from accessing it simultaneously.

### 2. **Using `Atomic References`**
- Used `AtomicReference` from `java.util.concurrent.atomic` to manage the state of the `Product` object in a thread-safe manner.
- Ensures non-blocking thread safety, enabling better performance in scenarios with high contention.

---


# Comparison of AtomicReference and synchronized in Java

## Table 1: Key Differences

| **Aspect**               | **AtomicReference**                                 | **synchronized**                              |
|---------------------------|----------------------------------------------------|-----------------------------------------------|
| **Mechanism**            | Lock-free, non-blocking                            | Lock-based, blocking                          |
| **Performance**          | Faster for single-variable updates                 | Slower due to locking and context-switching overhead |
| **Complexity**           | Easy for single-variable operations, harder for compound actions | Simpler to handle multiple variables         |
| **Deadlock Risk**        | None                                               | Possible if locks are not managed properly    |
| **Use Case**             | Atomic updates of single variables                 | Coordinating complex or multi-step operations |
| **Scalability**          | Better in high-concurrency scenarios               | Degrades under high contention                |

---

## Table 2: When to Use

| **Scenario**                                | **Use `AtomicReference`**           | **Use `synchronized`**             |
|---------------------------------------------|--------------------------------------|-------------------------------------|
| **Single Variable Updates**                 | ✅                                   | ❌                                  |
| **High-Concurrency (Many Threads)**         | ✅ (Efficient, non-blocking)         | ❌ (Locks may slow things down)     |
| **Multiple Variable/Step Updates**          | ❌                                   | ✅                                  |
| **Avoiding Deadlocks**                      | ✅ (No locks involved)               | ❌ (Locks can lead to deadlocks)    |
| **Complex Multi-Step Logic**                | ❌                                   | ✅                                  |
| **Performance Under Low Contention**        | ✅                                   | ✅                                  |
| **Legacy Code or Broad Synchronization**    | ❌                                   | ✅                                  |

