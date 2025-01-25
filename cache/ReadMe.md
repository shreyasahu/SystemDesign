# Cache Library - Normal Cache and Time-Based Cache

## Overview
This document describes the implementation of a cache library that supports both normal caching and time-based caching (TTL - Time-To-Live). The cache is designed to store key-value pairs with efficient operations for adding, retrieving, and cleaning expired entries. It handles edge cases like expiration, refreshing TTL on access, and failure scenarios effectively.

---

## Problem Statement
1. **Normal Cache**: Implement a basic cache library that stores key-value pairs with an eviction policy when the capacity is exceeded.
2. **Time-Based Cache**: Extend the cache to support TTL (Time-To-Live) for entries, ensuring entries are invalidated after a specified duration.

---

## Implementation Details

### Normal Cache
#### Features:
- Stores key-value pairs with a fixed capacity.
- Automatically evicts the least recently added entries when capacity is exceeded.

---

### Time-Based Cache
#### Features:
- Each entry has a TTL (Time-To-Live) duration.
- Automatically removes expired entries.
- Optionally refreshes TTL on access.

#### Steps:
1. **Data Structure**: Use a `ConcurrentHashMap` to store entries, each with a timestamp for expiration.
2. **Lazy Expiration**: Check TTL on every `get()` or `put()` call and remove expired entries dynamically.
3. **Scheduler Alignment**: Use a `ScheduledExecutorService` to periodically clean up expired entries at aligned times.
---

## Usage Instructions
1. **Normal Cache**:
    - Go to NormalCacheDriver class for usage

2. **Time-Based Cache**:
    - Go to TimeBasedDriver class for usage

---

## Additional Information


### Summary: Concurrency in Cache Library

1. **Use Thread-Safe Data Structures**:
    - Use `ConcurrentHashMap` for thread-safe operations.

2. **Avoid Global Locks**:
    - Use fine-grained locks (e.g., per key/entry) or `ReentrantReadWriteLock` for better performance.

3. **Atomic Operations**:
    - Use methods like `computeIfAbsent` or `putIfAbsent` to handle updates safely.

4. **Background Cleanup**:
    - Use a `ScheduledExecutorService` for TTL-based cleanup without blocking main threads.

5. **Prevent Deadlocks**:
    - Lock in a consistent order and avoid nested locks.

6. **Test for Performance**:
    - Avoid over-synchronization to prevent bottlenecks.

This ensures a scalable, efficient, and thread-safe cache implementation.
