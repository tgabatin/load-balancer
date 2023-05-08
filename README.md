# Load Balancer
A simulation of load balancer algorithms simulated in Java through text-based representation. 

Load Balancer Represenations
### Round Robin

The Round Robin is based on the technique that is used to distribute various incoming network traffic evenly amongst a given group of servers. This works through cycling through the list of servers, and sending the incoming requests to each server in turn. 

The Round Robin algorithm will ensure that all servers receive an equal share of the incoming network traffic, and prevents any one server from becoming overwhelmed with the incoming requests.

                    ┌─────────────┐
          Request   │ Load Balancer │   Request
         ─────────>│  ───────────  │───────────>
                    │ │ Server 1 │ │
                    │ └─────────────┘ │
                    │                 │
                    │ │ Server 2 │ │
                    │ └─────────────┘ │
                    │                 │
                    │ │ Server 3 │ │
          Response  │ └─────────────┘ │  Response
         <───────── │                 │<─────────
                    └─────────────┘


### Sticky Round Robin

The Sticky Round Robin (SRR) is similar to the Round Robin algorithm. This algorithm attempts to maintain a consistent mapping of the clients to their respective servers. The clients initial request is assigned a unique identifier, such as a cookie or session ID to each of the clients request, then uses this identifier to route all requests from the same client to the same server. 

                    ┌─────────────┐
          Request   │ Load Balancer │   Request
         ─────────>│  ───────────  │───────────>
                    │ │ Server 1 │ │
                    │ └─────────────┘ │
                    │     ↑           │
                    │     │           │
                    │     │   ┌─────────────┐
                    │     │───│  Server 2   │
                    │         └─────────────┘
                    │
                    │
          Request   │ │ Server 3 │ │   Request
         ─────────>│ └─────────────┘ │───────────>
                    │                 │
                    │     ↑           │
                    │     │           │
                    │     │   ┌─────────────┐
                    │     │───│  Server 1   │
                    │         └─────────────┘
                    │
          Response  │ └─────────────┘  Response
         <───────── │
                    └─────────────┘


### Weighted Round Robin

The Weighted Round Robin (WRR) is another variation of the Round Robin algorithm. This algorithm works by assigning a weight to each of the severs within the model. This weight can thus represent the proportion of the traffic that should be directed to each server. Servers with the higher weights will receive a larger proportion of the traffic, while servers with the lower weights will receive the samller proportion.

              ┌─────────────────┐
  Request     │   Load Balancer  │     Request
 ────────────>│   ────────────  │────────────>
              │   Server 1 (5)  │
              │ ┌───────────────┐│
              │ │ Server 2 (3)   │
              │ └───────────────┘│
              │     ↑             │
              │     │             │
              │     │ ┌───────────────┐
              │     │ │ Server 3 (2)   │
              │     │ └───────────────┘
  Response    │ └─────────────────┘  Response
 <────────────│
              └─────────────────┘


### Least Connections

The Least Connection algorithm is another load balacing algorithm that is used to distribute the network traffic to severs with the fewest active connections. This works by monitoring the number of active connections to each servers and forwarding the incoming requests to the servers that has the lowest number of active connections. It helps to evenly distribute network traffic among servers, overall preventing one server from becoming overwhelmed from multiple connections.

              ┌──────────────────┐
  Request     │   Load Balancer   │     Request
 ────────────>│   ─────────────  │────────────>
              │   Server 1 (3)    │
              │ ┌────────────────┐│
              │ │ Server 2 (2)    │
              │ └────────────────┘│
              │     ↑              │
              │     │              │
              │     │ ┌────────────────┐
              │     │ │ Server 3 (1)    │
              │     │ └────────────────┘
  Response    │ └──────────────────┘  Response
 <────────────│
              └──────────────────┘


### Least Time

The Least Time algorithm is a technique that is primarily used to distribute the incoming network traffic to the server with the shortest response time. This works by monitoring the response time of each of the individual servers, and forwarding these incoming requests to the server that has the shortest response time. This will help to ensure that the clients receive the fastest response possible in relation to the servers. 

              ┌─────────────────┐
  Request     │  Load Balancer  │     Request
 ────────────>│  ────────────  │───────────>
              │ Server 1 (100ms)│
              │ ┌───────────────┐│
              │ │ Server 2 (50ms)│
              │ └───────────────┘│
              │     ↑             │
              │     │             │
              │     │ ┌───────────────┐
              │     │ │ Server 3 (75ms)│
              │     │ └───────────────┘
  Response    │ └─────────────────┘  Response
 <────────────│
              └─────────────────┘


### IP-URL Hash

This algorithm is used to distribute the incoming network traffic to a server that is based on the hash of a client's IP address and the requested URL. It works by calculating the hash of the IP address and URL of each of the incoming requests, and then uses the hash value to select the server from a pool of available servers. This will help to ensure that the requests from the same client for the same URL will always be directed to the same server. 

                ┌─────────────────┐
   Request      │  Load Balancer  │     Request
 ──────────────>│  ────────────  │───────────>
                │     Server 2    │
                │ ┌───────────────┐│
                │ │     Server 1   │
                │ └───────────────┘│
                │       ↑         │
                │       │         │
                │       │ ┌───────────────┐
                │       │ │     Server 2   │
                │       │ └───────────────┘
   Response     │ └─────────────────┘  Response
  <─────────────│
                └─────────────────┘
