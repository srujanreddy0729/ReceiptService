# Receipt Processor
 I have created a Java-based web service using Spring Boot that fulfills the API requirements. The service will have the following features:

 # Endpoints:
   - POST /receipts/process to process receipts and return a unique receipt ID.
   - GET /receipts/{id}/points to retrieve the awarded points for a given receipt ID.
   - **In-Memory Storage**: The service will use an in-memory data structure (e.g., ConcurrentHashMap) to store receipts and their corresponding   points.
   - **Point Calculation Rules**: Implements all the specified rules to calculate points.
   - **Docker Support**: A Dockerfile will be provided to containerize the application for easy execution.
     
