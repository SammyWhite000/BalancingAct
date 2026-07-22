# BalancingAct

##  A “life auction” game

Players allocate fictional or real constrained resources across competing priorities:

Time
Money
Social energy
Career capital
Health
Reputation
Freedom

Each round introduces events and tradeoffs.

Players must decide what they are willing to sacrifice.

This could be:

A party game
A planning exercise
A classroom tool
A values-discovery product
A team-alignment workshop

The core could be a flexible allocation and consequence engine

--------------------------------------------------------------------------------

## Development Plan

Life Auction is a single-player web game built by two developers to practice OOP, OOD, full-stack development, and collaborative GitHub workflows.

### Technology Stack

**Frontend**

* React
* TypeScript
* Vite
* Tailwind CSS
* Zustand only if shared client state becomes necessary

**Backend**

* Java
* Spring Boot
* Spring MVC
* Spring Data JPA
* Hibernate
* Flyway

**Database**

* PostgreSQL
* Docker Compose for the local development database

**Testing**

* JUnit 5
* AssertJ
* jqwik
* Testcontainers
* Playwright

**Collaboration and Delivery**

* GitHub monorepo
* GitHub Issues and Projects
* Feature branches and pull requests
* GitHub Actions
* Protected `main` branch

### Architecture

The project will use a modular monolith with a server-authoritative game engine.

```text
React Frontend
      |
   HTTP/JSON
      |
Spring Boot Backend
      |
  PostgreSQL
```

The frontend handles presentation, animation, and user input.

The backend owns:

* Game rules
* Bid validation
* NPC decisions
* Resource changes
* Consequence resolution
* Game progression
* Ending calculation

Core domain logic should remain independent of Spring whenever practical.

### Initial Project Structure

```text
life-auction/
├── backend/
├── frontend/
├── game-content/
├── docs/
├── .github/
├── compose.yaml
├── .env.example
└── README.md
```

### MVP Scope

The first playable version should include:

* One human player
* Three simulated bidders
* Five to eight life resources
* Eight to twelve auction rounds
* Two auction mechanisms
* Life events between rounds
* Save and resume
* A final life outcome
* External game-content definitions

Potential resources include:

* Time
* Money
* Health
* Relationships
* Freedom
* Purpose
* Status
* Stability

Multiplayer, user accounts, payments, leaderboards, mobile applications, and user-created content are outside the initial MVP.

### Core Gameplay Loop

```text
Round begins
    ↓
Life opportunity appears
    ↓
Player bids or passes
    ↓
NPCs respond
    ↓
Auction resolves
    ↓
Costs and consequences apply
    ↓
Life event occurs
    ↓
Next round
```

### Development Phases

#### Phase 0: Validate the Game

* Define resources, auction rules, NPC behavior, and endings.
* Create sample opportunities.
* Playtest the game using paper or notes.
* Confirm that the core loop is enjoyable before coding.

#### Phase 1: Project Setup

* Create the GitHub monorepo.
* Configure Spring Boot and React.
* Add PostgreSQL through Docker Compose.
* Add Flyway migrations.
* Configure linting, testing, and GitHub Actions.
* Document local setup.

#### Phase 2: Java Domain Engine

Model the core game independently of the web framework:

* `GameSession`
* `Player`
* `ResourcePortfolio`
* `Auction`
* `AuctionLot`
* `Bid`
* `SimulatedBidder`
* `LifeEvent`
* `GameOutcome`

Initial commands:

* Start game
* Open auction
* Place bid
* Pass
* Resolve auction
* Advance round
* Complete game

Random behavior must use a saved seed so games and bugs can be reproduced.

#### Phase 3: First Vertical Slice

Build one complete auction across every layer:

1. Start a game.
2. Display player resources.
3. Open one auction.
4. Submit a bid.
5. Resolve NPC bids.
6. Determine the winner.
7. Apply resource changes.
8. Save the game.
9. Restore the game after refreshing.

This becomes version `v0.1.0`.

#### Phase 4: Complete Gameplay

* Add multiple rounds.
* Add life stages.
* Add two auction mechanisms.
* Add NPC strategies.
* Add life events.
* Add prerequisites and exclusions.
* Add game completion and endings.
* Add save, resume, and restart.

This becomes version `v0.2.0`.

#### Phase 5: Externalize Content

Store opportunities, events, NPC profiles, and endings outside Java source code.

```text
game-content/
├── auction-items/
├── life-events/
├── npc-profiles/
├── endings/
└── schemas/
```

A new opportunity should be addable without changing Java code.

This becomes version `v0.3.0`.

#### Phase 6: Playtesting and Balancing

* Test with users outside the development team.
* Identify confusing rules and dominant strategies.
* Adjust costs, rewards, NPC values, and probabilities through configuration.
* Record basic anonymous gameplay events for analysis.

This becomes version `v0.4.0`.

#### Phase 7: MVP Release

* Improve responsive design and accessibility.
* Add clear loading and error states.
* Add structured backend logging.
* Add validation and health checks.
* Automate the critical gameplay path with Playwright.
* Document deployment and release procedures.

This becomes version `v1.0.0`.

### GitHub Workflow

1. Create or select a GitHub issue.
2. Create a short-lived branch.

```text
feature/auction-engine
feature/resource-dashboard
fix/duplicate-consequence
```

3. Implement the feature.
4. Push the branch.
5. Open a pull request.
6. Run automated CI checks.
7. Have the other developer review the change.
8. Squash and merge into `main`.
9. Delete the branch.

Pull requests should explain:

* What changed
* Why it changed
* How to test it
* Relevant design decisions
* Tests added
* Screenshots for UI changes

### Team Workflow

Do not permanently divide the project into a frontend developer and backend developer.

Rotate responsibility by feature so both developers work with:

* Java
* Spring Boot
* React
* PostgreSQL
* Domain modeling
* Testing
* Architecture

Pair on domain design before splitting implementation work.

### Definition of Done

A feature is complete when:

* Acceptance criteria are met.
* Domain rules are tested.
* CI passes.
* The other developer has reviewed it.
* Documentation is updated.
* No secrets or local configuration are committed.
* The feature can be demonstrated.

### Architecture Guardrails

* Keep the backend authoritative.
* Keep Spring out of the core domain where practical.
* Avoid one large `GameService`.
* Put behavior inside meaningful domain objects.
* Use interfaces only where behavior genuinely varies.
* Do not hard-code every game card in Java.
* Do not add microservices, Redis, or Kubernetes to the MVP.
* Preserve `PlayerId`, game versioning, commands, and idempotent action IDs for possible future multiplayer.

### Milestones

| Version | Goal                                    |
| ------- | --------------------------------------- |
| `v0.0`  | Game rules validated on paper           |
| `v0.1`  | One persistent auction works end to end |
| `v0.2`  | Full playable game loop                 |
| `v0.3`  | Externalized game content               |
| `v0.4`  | Playtested and balanced                 |
| `v1.0`  | Public MVP                              |

The immediate priority is `v0.1`: one complete auction from React, through Java, into PostgreSQL, and back.

