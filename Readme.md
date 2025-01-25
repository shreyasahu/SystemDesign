# System Design Questions

This document showcases a list of frequently asked system design questions, along with example scenarios to prepare for interviews or to build a deeper understanding of distributed systems.

## **1. Design a URL Shortener**
- **Problem**: Build a service like TinyURL that converts long URLs into short, unique ones.
- **Key Concepts**:
    - Database schema for storing URLs.
    - Hashing algorithms for generating short URLs.
    - Handling collisions.
    - Scalability and distributed storage.

---

## **2. Design a Rate Limiter**
- **Problem**: Implement a system to limit the number of requests a user can make to an API within a given time window.
- **Key Concepts**:
    - Sliding window vs. token bucket algorithms.
    - Storing rate-limiting metadata.
    - Distributed rate limiting in a multi-server setup.

---

## **3. Design a Messaging Queue**
- **Problem**: Build a distributed message queue like RabbitMQ or Kafka.
- **Key Concepts**:
    - Producers, consumers, and topics.
    - Message durability and ordering.
    - Fault tolerance and replication.

---

## **4. Design a Social Media Feed**
- **Problem**: Create a system to generate and display personalized feeds for users.
- **Key Concepts**:
    - Feed generation techniques (push vs. pull models).
    - Storing and retrieving posts.
    - Real-time updates and caching.

---

## **5. Design an E-Commerce Platform**
- **Problem**: Build a platform like Amazon to support product browsing, searching, and purchasing.
- **Key Concepts**:
    - Catalog and inventory management.
    - Search functionality and ranking algorithms.
    - Order processing and payment systems.

---

## **6. Design a Search Autocomplete System**
- **Problem**: Implement an autocomplete feature for a search engine.
- **Key Concepts**:
    - Trie data structures for efficient prefix search.
    - Ranking suggestions by popularity.
    - Handling multi-language and typo corrections.

---

## **7. Design a Video Streaming Platform**
- **Problem**: Build a service like YouTube to stream videos.
- **Key Concepts**:
    - Video storage and CDN integration.
    - Adaptive bitrate streaming.
    - Handling metadata and recommendations.

---

## **8. Design a Distributed Cache**
- **Problem**: Build a caching layer for a large-scale system.
- **Key Concepts**:
    - Cache eviction policies (e.g., LRU, LFU).
    - Data consistency between cache and database.
    - Scalability and fault tolerance.

---

## **9. Design a File Storage System**
- **Problem**: Build a system like Dropbox for storing and syncing files across devices.
- **Key Concepts**:
    - Chunking and deduplication.
    - Sync mechanisms and conflict resolution.
    - Metadata management and access control.

---

## **10. Design a Payment Gateway**
- **Problem**: Build a system to process online payments securely.
- **Key Concepts**:
    - Securely handling sensitive user information.
    - Integration with banks and payment processors.
    - Fraud detection and transaction logging.

---

## **11. Design a Ride-Sharing Service**
- **Problem**: Build a system like Uber for matching riders with drivers.
- **Key Concepts**:
    - Location tracking and matching algorithms.
    - Surge pricing and route optimization.
    - Real-time communication and user experience.

---

## **12. Design a Notification System**
- **Problem**: Implement a service to send notifications via email, SMS, and push notifications.
- **Key Concepts**:
    - Queues and priority handling.
    - Multi-channel notification strategies.
    - Retry policies and failover mechanisms.

---

## **13. Design a Hotel Booking System**
- **Problem**: Build a system for browsing and booking hotels.
- **Key Concepts**:
    - Availability search and pricing.
    - Managing reservations and cancellations.
    - Integrating with external hotel inventory providers.

---

## **14. Design a Logging and Monitoring System**
- **Problem**: Create a scalable system for log aggregation and monitoring.
- **Key Concepts**:
    - Log ingestion pipelines.
    - Indexing and querying logs.
    - Setting up alerts and dashboards.

---

## **15. Design a Content Delivery Network (CDN)**
- **Problem**: Build a system to deliver content like images, videos, or files to users efficiently.
- **Key Concepts**:
    - Caching at edge locations.
    - Load balancing and geo-replication.
    - Cache invalidation policies.

---

## **How to Use This Document**
- For each system design question, break the problem into smaller components, identify bottlenecks, and explain trade-offs.
- Practice whiteboarding or coding solutions for the scenarios.

---

Happy Learning and Designing!

