# Vending Machine Project

This project provides a low-level design implementation of a Vending Machine in Java. It demonstrates object-oriented principles and design patterns to simulate the functionalities of a vending machine.

## Project Structure

The project consists of the following classes and interfaces:

- **Classes:**
    - `Coin`: Represents a coin with a specific denomination.
    - `DispenseState`: Handles the state when the machine is dispensing a product.
    - `IdleState`: Represents the state when the machine is idle and awaiting user interaction.
    - `Inventory<T>`: Manages the inventory of items, such as products and coins.
    - `Note`: Represents a note with a specific denomination.
    - `Product`: Represents a product with a name and price.
    - `ReadyState`: Represents the state when the machine is ready to accept payment after a product selection.
    - `ReturnChangeState`: Handles the state when the machine is returning change to the user.
    - `VendingMachine`: Core class that manages the vending machine operations and state transitions.
    - `VendingMachineDemo`: Demonstrates the usage of the vending machine system (main class).

- **Interfaces:**
    - `VendingMachineState`: Defines the methods for various states of the vending machine.

## Design Patterns

The project employs the State design pattern to manage the various states of the vending machine, ensuring a clear separation of concerns and enhancing maintainability.

## Usage

To run the demonstration:

1. Compile all Java files in the directory.
2. Execute the `VendingMachineDemo` class, which contains the `main` method to demonstrate the vending machine operations.

