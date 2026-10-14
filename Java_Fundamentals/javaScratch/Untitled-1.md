> [!info] Know 20 topics at 95% rather than 80 topics at 60% 

### Tier 1,2 — Core Engineering

#### REST API Design
- [x]  Resource naming — nouns not verbs
- [x]  HTTP methods — GET, POST, PUT, PATCH, DELETE semantics
- [x]  Status codes — 200, 201, 204, 400, 401, 403, 404, 409, 500
- [x]  REST API Versioning — idiomatic REST, versioning, error response standards
- [x]  Versioning strategies — URI vs header vs query param
- [x]  Error response standard — consistent error body
- [x]  OpenAPI / Swagger — generate from Spring Boot
- [ ]  Domain Name Systems, Hosting
- [ ]  TCP IP - Which layers REST and gRPC are built on
- [ ]  CORS

#### Linux Commands

- [x]  Navigation & File System
- [x]  File Operations
- [x]  Viewing & Editing
- [ ]  Text Processing
- [ ]  Files
- [x]  User & Permissions
- [x]  Process Management
- [ ]  CPU & Memory Diagnostics
- [ ]  Disk & Storage
- [ ]  Networking
- [ ]  System Info
- [x]  Package Management
- [x]  Shell Utilities
- [x]  Service Management (Systemd)
- [ ]  Java / Sprin Boot Specific (Bonus)
- [ ]  How to Diagnose a Slow/Down Service — End to End

[[command book]]

#### Git

Git commands and concepts
[[git/commands]]

#### Java

- [ ]  Basics - tIll Classes
- [ ]  OOP - Class, Object, Encapsulation, Inheritance, Polymorphism, Abstraction
- [ ]  How JVM Works
- [ ]  HashMap internals — hashing, collision, resize, ConcurrentHashMap
- [ ]  Collections — ArrayList vs LinkedList, when to use which
- [ ]  Multithreading — Thread, Runnable, ExecutorService, thread pool
- [ ]  Synchronization — synchronized, volatile, ReentrantLock
- [ ]  CompletableFuture — async chaining, exception handling
- [ ]  Virtual Threads (Java 21) — what, why, difference from platform threads
- [ ]  Memory Management — heap, stack, GC types, when GC is a problem
- [ ]  Streams — map, filter, reduce, collectors, parallel streams gotchas
- [ ]  Exception Handling — checked vs unchecked, custom exceptions [%](https://www.geeksforgeeks.org/java/exceptions-in-java/)
- [ ]  Changes in Java since Java 1.7 each release (saw form intellij idea jdk configuration block)
- [ ]  major changes in java releases till java 26 that interviewer can ask
- [ ]  Interview Questions

#### Spring

- [ ]  Auto-Configuration — how Spring decides what to configure
- [ ]  Bean Lifecycle — creation, init, destroy
- [ ]  Dependency Injection — constructor (preferred) vs field vs setter, why constructor
- [ ]  @Conditional annotations — how auto-config is gated

#### Spring Boot

- [ ]  Spring Boot Starter — what it is, how it works internally, how to create custom one
- [ ]  Actuator — /health, /metrics, custom endpoints, securing them
- [x]  Profiles — @Profile, application-dev.yml, overriding in prod
- [ ]  Filter vs Interceptor vs AOP — when to use which
- [ ]  Custom Annotations — how to build one
- [ ]  Spring Events — ApplicationEvent, @EventListener

#### ==Spring Cloud==

- [x]  Service Discovery — Consul / Eureka
- [x]  Centralized Configuration - Spring Cloud Config Server, Config refresh
- [x]  Spring Cloud Load Balancer — client-side LB, round-robin, custom
- [x]  Circuit Breaker — Resilience4j, states, fallback, Retry, Bulkhead, RateLimiter
- [x]  API Gateway — Spring Cloud Gateway, routing, auth filter, rate limiting
- [x]  Distributed Tracing, Metrics, Logs
- [ ]  Saga Pattern POC — build a 3-service choreography saga

#### Relational Databases

- [ ]  **What is a Relational Database?** — Data stored in tables (rows + columns) with relationships between them, queried using SQL
- [ ]  **Core SQL** — `SELECT`, `INSERT`, `UPDATE`, `DELETE` — the four operations everything is built on
- [ ]  **Primary Key & Foreign Key** — PK uniquely identifies a row; FK links one table to another (the "relation" in relational)
- [ ]  **Joins** — `INNER JOIN`, `LEFT JOIN`, `RIGHT JOIN` — how you combine data from multiple tables in a single query
- [ ]  **Normalization** — Organizing tables to reduce redundancy; 1NF → 2NF → 3NF, each level removes a type of duplication
- [ ]  **NULL** — Represents missing/unknown data; not the same as 0 or empty string, behaves differently in comparisons
- [ ]  **Constraints** — Rules enforced by the DB: `NOT NULL`, `UNIQUE`, `CHECK`, `DEFAULT`, `FOREIGN KEY`
- [ ]  **Basic Indexing Intuition** — An index is like a book's index — speeds up lookups at the cost of extra storage and slower writes
- [ ]  **ORM Basics (Hibernate / JPA)** — Maps Java classes to DB tables; understand `@Entity`, `@Table`, `@Id`, `@OneToMany`, `@ManyToOne`
- [ ]  **Connection Pooling** — DBs can't handle unlimited simultaneous connections; a pool (like HikariCP) reuses a fixed set of connections efficiently
- [ ]  **ACID** — Atomicity (all or nothing), Consistency (DB stays valid), Isolation (transactions don't interfere), Durability (committed data survives crashes)
- [ ]  **Transaction Isolation Levels** — Read Uncommitted → Read Committed → Repeatable Read → Serializable; each trades performance for stricter guarantees
- [ ]  **Dirty Read** — Reading data from a transaction that hasn't committed yet (possible only at Read Uncommitted)
- [ ]  **Non-Repeatable Read** — Same row read twice in a transaction returns different values because another transaction updated it in between
- [ ]  **Phantom Read** — Same query run twice returns different rows because another transaction inserted/deleted rows in between
- [ ]  **B-Tree Index** — The default index structure; keeps data sorted, efficient for range queries and equality checks
- [ ]  **Composite Index** — Index on multiple columns; column order matters — follows left-prefix rule
- [ ]  **Covering Index** — Index that contains all columns a query needs, so DB never touches the actual table
- [ ]  **When Index Hurts** — High write tables (index must be updated on every write), low cardinality columns (e.g. boolean), small tables
- [ ]  **EXPLAIN Plan** — Shows how the DB executes a query; look for `Seq Scan` (bad on large tables), `Index Scan` (good), `Nested Loop` vs `Hash Join`
- [ ]  **N+1 Problem** — 1 query fetches N parents, then N separate queries fetch each child; fix with `JOIN FETCH` or `@EntityGraph` in JPA
- [ ]  **Migrations** — Versioned, incremental SQL scripts applied in order; use Flyway or Liquibase to manage schema changes across environments
- [ ]  **Elasticsearch** — Not a relational DB; a search engine built for full-text search, log analysis, and fast reads on large datasets using inverted indexes
- [ ]  **Database Schema Design** — Define entities, relationships (1:1, 1:N, M:N), pick correct data types, plan for indexes early, avoid over-normalization for read-heavy systems

#### Persistence

- [ ]  Spring JdbcTemplate
- [ ]  Transactions — @Transactional, propagation, isolation levels
- [ ]  N+1 Problem — what it is, how to fix (fetch join, EntityGraph)
- [ ]  Database Connection Pooling — HikariCP, tuning
- [ ]  Optimistic vs Pessimistic Locking — @Version, when to use which
- [ ]  (opt) Spring Data JPA — repositories, query methods, JPQL

#### REST Client calls

- [ ]  Synchronous Calls
- [ ]  Parallel Calls
- [ ]  Asynchronous Calls
- [ ]  Spring RestClient

#### Networking Depth

- [ ]  TCP handshake cost, connection reuse, keep-alive
- [ ]  What happens in a slow network — retries, timeouts, circuit breaker connection
- [ ]  HTTP/2 vs HTTP/1.1 — multiplexing, why it matters for microservices
- [ ]  Connection pooling at the HTTP level (not just DB)

#### Performance

- [x]  Linux Commands
- [x]  CPU
- [x]  Memory
- [x]  Disc
- [ ]  Network
- [ ]  IPv4 v6 Private public IP, DNS
- [x]  Load Testing
- [x]  What is Latency and Throughput

#### Kafka & Event Driven Systems 

- [ ]  Kafka architecture — broker, topic, partition, offset, consumer group
- [ ]  Why partitions — parallelism, ordering guarantee within partition only
- [ ]  Consumer group rebalancing — what triggers it, impact
- [ ]  @KafkaListener — concurrency, error handling, retry
- [ ]  KafkaTemplate — sending, transactions
- [ ]  Idempotent consumers — why duplicate messages happen, how to handle
- [ ]  Outbox Pattern — why needed, transactional outbox with DB
- [ ]  Event Driven Architecture — choreography vs orchestration trade-offs
- [ ]  Dead Letter Topic — what it is, when messages go there

#### Distributed Systems - Observability

- [x]  Distributed Tracing — Micrometer, OTel Agent, Tempo
- [x]  Distributed Logging — Grafana Loki, correlation via traceId
- [x]  Distributed Transactions — Saga Pattern (Choreography vs Orchestration)
- [ ]  CAP Theorem — consistency vs availability, real examples
- [ ]  Eventual Consistency — what it means in practice
- [ ]  Alerting basics — what to alert on vs what to log (error rate, p99 latency, saturation)
- [ ]  SLO / SLI / SLA — definitions + one real example
- [ ]  On-call thinking — how you'd debug a latency spike in prod

Failure Modes & War Stories

- [ ]  What fails under load
- [ ]  What fails silently (worse)
- [ ]  How you'd know it's failing (observability)
- [ ]  How you'd fix it without downtime

#### LLM and Spring AI

- [ ]  How LLM works — transformer, tokens, context window
- [ ]  RAG — retrieval augmented generation, vector DB
- [ ]  Vector databases — embeddings, similarity search
- [ ]  Spring AI — chat client, embeddings, RAG with Spring Boot
- [ ] [Anthropic Skills](https://anthropic.skilljar.com/)

#### Behavioral / HR Prep (missing entirely)

- [ ]  STAR format stories — ownership, conflict, failure, impact
- [ ]  "Tell me about yourself" — crisp 90-second version
- [ ]  Why this company — per company research (Flipkart vs CRED vs Zepto have different cultures)
- [ ]  Salary negotiation basics

#### Testing

- [ ]  Unit testing — JUnit 5, Mockito, @MockBean vs @Mock
- [ ]  Integration testing — @SpringBootTest, Testcontainers
- [ ]  Testing slices — @WebMvcTest, @DataJpaTest
- [ ]  What to mock vs what not to

---

### TIER 3 — Advanced Engineering

#### Performance & Scalability

- [ ]  JVM tuning basics — heap size, GC types, when to tune
- [ ]  Thread pool tuning — core vs max threads, queue capacity
- [ ]  Database indexing — composite indexes, covering indexes, explain plan
- [ ]  Query optimization — common slow query patterns
- [ ]  Horizontal vs Vertical scaling — trade-offs, stateless services

#### Containers & Deployment

- [ ]  Docker — Dockerfile for Spring Boot, multi-stage build, layers
- [ ]  Docker Compose — local microservices setup
- [ ]  Kubernetes — Pod, Service, Deployment, ConfigMap, Secrets
- [ ]  K8s health probes — liveness vs readiness, how Spring Actuator maps
- [ ]  CI/CD — blue/green, canary, feature flags

#### System Design

- [ ]  Rate Limiting — token bucket vs leaky bucket algorithms
- [ ]  Idempotency — idempotency keys in APIs
- [ ]  Pagination — cursor vs offset, why cursor is better at scale
- [ ]  CAP Theorem — real examples: Cassandra (AP), ZooKeeper (CP)
- [ ]  Async processing — @Async, CompletableFuture, thread pool tuning
- [ ]  Webhook design — delivery guarantees, retries, signatures
- [ ]  Eventual Consistency — real example with Kafka + Saga
- [ ]  Horizontal scaling — stateless services, session externalization
- [ ]  CQRS — Command Query Responsibility Segregation
- [ ]  Event Sourcing — storing events as source of truth
- [ ]  Service Mesh — Istio, what it does vs Spring Cloud
- [ ]  gRPC — protobuf, when to use over REST
- [ ]  WebFlux — reactive programming, when NOT to use it

System Design Problems (practice these)
- [ ]  Design a URL shortener
- [ ]  Design a notification system
- [ ]  Design an order management system
- [ ]  Design a rate limiter
- [ ]  Design a payment system (idempotency focus)

#### LLD

- [ ]  SOLID principles — one real Spring Boot example each
- [ ]  Design Patterns — Factory, Builder, Strategy, Observer, Decorator
- [ ]  LLD: Design a Parking Lot
- [ ]  LLD: Design a Rate Limiter
- [ ]  LLD: Design a Notification System
- [ ]  LLD: Design a Cache

#### DSA

- [ ]  Arrays & Strings — two pointer, sliding window
- [ ]  HashMap problems — frequency count, anagram, subarray sum
- [ ]  Binary Search — on answer, rotated array
- [ ]  Trees — BFS, DFS, LCA
- [ ]  Graphs — BFS, DFS, cycle detection
- [ ]  Dynamic Programming — 1D DP (climb stairs, house robber)
- [ ]  Stack — next greater element, valid parentheses

**Target: 100 LC problems (70% medium, 30% easy)**

#### Security

- [ ]  Spring Security architecture — filter chain, SecurityContext
- [ ]  Security Filter Chain — how filters execute, order matters
- [ ]  SecurityContext — how auth is stored per request
- [ ]  JWT — structure, validation, refresh tokens
- [ ]  JWT structure — header.payload.signature, what each contains
- [ ]  JWT validation flow — parsing, signature check, expiry
- [ ]  Refresh token strategy — why, how to rotate, where to store
- [ ]  OAuth2 — authorization code flow, client credentials
- [ ]  Method level security — @PreAuthorize, @Secured
- [ ]  API Gateway auth — validate JWT once, propagate userId downstream

#### Redis & Spring Cache

- [ ]  @Cacheable, @CacheEvict, @CachePut — differences, when to use each
- [ ]  Redis data structures — String, Hash, List, Set, Sorted Set — real use cases
- [ ]  TTL & eviction policies — LRU, LFU, when to choose which
- [ ]  Cache aside pattern — read flow, write flow
- [ ]  Write through vs Write behind — trade-offs
- [ ]  Cache stampede — what it is, fix with mutex / probabilistic early expiry
- [ ]  Redis vs in-memory cache — when to use which
- [ ]  Distributed locking with Redis — Redisson, why it's tricky

---

### TIER 4 — Bonus 

(Staff/Principal signal, nice to have for 3YOE)

#### gRPC

#### WebFlux

#### Architectural Pattern 
- [ ]  Microservices vs Monolith
- [ ]  Serverless
- [ ]  Service Mesh
- [ ]  Twelve factor apps
- [ ]  ACID
- [ ]  SOLID
- https://roadmap.sh/backend


---

### The Framework — After Every Topic

```
Step 1 — LEARN    → Notes in Obsidian (concept + code)
Step 2 — BUILD    → Small POC, even 2-3 services locally
Step 3 — BREAK    → Simulate failure, what happens?
Step 4 — EXPLAIN  → Write interview answer out loud
Step 5 — CONNECT  → Link to related notes in Obsidian
```

Interview Answer Formula (for every topic)

```
1. Problem    — what breaks without this
2. Solution   — what this does at a high level
3. Internals  — how it works (the impressive part)
4. Code       — one key annotation or config you know cold
5. Production — real trade-off or gotcha
```
 