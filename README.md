# Bar op Kamp

Hieronder vind je een overzicht van de reeds gekende domeinen.

```mermaid
graph TD
    Camp["Camp (Kamp)"]
    Participants["Participants (Deelnemers)"]
    Volunteers["Volunteers (Vrijwilligers)"]
    Products["Products (Producten)"]
    Sales["Sales (Verkoop)"]
    Auth["Authentication (QR + PIN Login)"]
    
    Camp --> Participants
    Camp --> Volunteers
    Camp --> Products
    
    Volunteers --> Auth
    Sales --> Participants
    Sales --> Volunteers
    Sales --> Products
```