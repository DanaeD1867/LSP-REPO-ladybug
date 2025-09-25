Assignment 2 was initially implemented as a monolithic block of code, with all functionality tightly packed into a single main method. While the logic worked, the structure made the program harder to maintain, understand, and test. There was little to no separation of concerns, and the structure of the code meant that modifying or extending the code in the future would require significant rewrites.

In contrast, Assignment 3 is a significant improvement both in structure and in alignment with object-oriented programming (OOP) principles. With the help of suggestions from ChatGPT, I refactored the codebase to break the pipeline into discrete classes, each responsible for a specific step in the pipeline. This approach allowed me to design the application more like an assembly line, where each component performs a distinct role and then hands off to the next step.

### Design Differences:
The most notable difference in design is how the logic is divided. In Assignment 2, all processing—from reading files to parsing records to output—was done in a single place. In Assignment 3, these responsibilities were divided into separate classes. This modular approach adheres closely to the Single Responsibility Principle.

### Object-Oriented Principles Used:
Assignment 3 demonstrates a much more object-oriented design. I made use of several core OOP concepts:

- Classes and Objects: Each processing step was encapsulated into its own class, and instances of those classes were used to manage data and behavior.

- Encapsulation: Internal logic and data were kept private within classes, exposing only necessary interfaces to interact with other components.

- Modularity and Reusability: By encapsulating behavior into classes, I’ve made it easier to reuse components in other contexts or projects.

### Testing and Verification:
To ensure that Assignment 3 maintained the same functional behavior as Assignment 2, I tested both versions using the same input scenarios:

- A file with correctly formatted, expected records.

- An empty file.

- A file with malformed or incomplete records.

In Assignment 2, malformed records were processed alongside valid records, often resulting in unexpected behavior. In Assignment 3, I improved the error handling by explicitly skipping invalid records and logging them to the console. This makes it clear to the user what was skipped and why, improving both transparency and usability.

Additionally, I modified the output behavior: instead of writing the summary to the output file as in Assignment 2, Assignment 3 prints the summary directly to the console. This design choice was made to save time for the user and improve visibility of the program's final status without requiring them to open another file.

Overall, Assignment 3 is a cleaner, more maintainable, and more professional implementation. By leveraging OOP principles, I created a system that is easier to understand, debug, and extend. This refactoring exercise not only improved the code quality but also deepened my understanding of object-oriented design and its practical benefits in real-world applications.