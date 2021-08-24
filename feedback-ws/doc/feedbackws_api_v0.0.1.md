Feedback Web Service API v0.0.1-SNAPSHOT
=====================================

### Environments

- Dev: http://localhost:8080/api/v1

### Supported HTTP/1.1 Methods

- GET, POST, PUT, DELETE are supported.
- CRUD operations map to POST, GET, PUT, DELETE respectively.

### Authentication

Web service is unauthenticated.

### Persistence

- Web service uses H2 (https://h2database.com) embedded in-memory database.
- Database schema is derived from entity objects automatically at runtime.
- Database console is available at: http://localhost:8080/h2-ui/
- Data will *not* be persisted after web service shutdown.

### Web Service Metrics

**Endpoint: GET /actuator**

- Description: Provides web service build information.

- Request: GET http://localhost:8080/actuator/info

- Response: 200 OK

  ```json
  {
      "build": {
          "artifact": "feedbackws",
          "name": "Feedback Web Service",
          "time": "2021-08-22T23:45:45.791Z",
          "version": "0.0.1-SNAPSHOT",
          "group": "com.shakoori.reza"
      }
  }
  ```

- Request: GET http://localhost:8080/actuator/health

  ```json
  {
      "status": "UP"
  }
  ```

----------

## Patient

### Create Patient

**Endpoint: POST /patient/**

- Description: Creates a new patient - with optional feedback(s). Full feedbacks CRUD functionality is described in next section.

- Request (positive): POST http://localhost:8080/api/v1/patient/

  ```json
  {
      "id": "b3db2be0-1b2f-45eb-8fc7-5c72fba379ab",
      "firstName": "Barbara",
      "lastName": "Zimmerman",
      "birthDate": "1964-03-06",
      "gender": "FEMALE",
      "feedbacks": [
          {
              "id": "55d097dc-18eb-4bca-9bd0-63c26d0999e0",
              "patientId": "b3db2be0-1b2f-45eb-8fc7-5c72fba379ab",
              "npi": "1245319599",
              "rating": 8,
              "comment": "Very attentive doctor"
          },
          {
              "id": "d0367f4e-16a3-478a-ace9-d4c43248f5c8",
              "patientId": "b3db2be0-1b2f-45eb-8fc7-5c72fba379ab",
              "npi": "1245319588",
              "rating": 2,
              "comment": "Had to wait way too long"
          }
      ]
  }
  ```

- Response (positive): 200 OK

  ```json
  {
      "id": "b3db2be0-1b2f-45eb-8fc7-5c72fba379ab",
      "firstName": "Barbara",
      "lastName": "Zimmerman",
      "birthDate": "1964-03-06",
      "gender": "FEMALE",
      "feedbacks": [
          {
              "id": "55d097dc-18eb-4bca-9bd0-63c26d0999e0",
              "patientId": "b3db2be0-1b2f-45eb-8fc7-5c72fba379ab",
              "npi": "1245319599",
              "rating": 8,
              "comment": "Very attentive doctor"
          },
          {
              "id": "d0367f4e-16a3-478a-ace9-d4c43248f5c8",
              "patientId": "b3db2be0-1b2f-45eb-8fc7-5c72fba379ab",
              "npi": "1245319588",
              "rating": 2,
              "comment": "Had to wait way too long"
          }
      ]
  }
  ```

- Request (positive): POST http://localhost:8080/api/v1/patient/

  ```json
  {
      "firstName": "Lily",
      "lastName": "Mizrahi",
      "birthDate": "1980-01-01",
      "gender": "FEMALE"
  }
  ```

- Response (positive): 200 OK

  ```json
  {
      "id": "decf7294-02e4-4155-b1e4-70f9a3ba00b9",
      "firstName": "Lily",
      "lastName": "Mizrahi",
      "birthDate": "1980-01-01",
      "gender": "FEMALE",
      "feedbacks": []
  }
  ```

- Request (negative): POST http://localhost:8080/api/v1/patient/

  ```json
  {
  }
  ```

- Response (negative): 400 Bad Request

  ```json
  {
      "timestamp": "2021-08-24T03:34:59.749+00:00",
      "status": 400,
      "error": "Bad Request",
      "message": "Validation failed for object='patientDto'. Error count: 6",
      "errors": [
          {
              "defaultMessage": "First name is required"
          },
          {
              "defaultMessage": "First name is required"
          },
          {
              "defaultMessage": "First name cannot be blank"
          },
          {
              "defaultMessage": "Last name is required"
          },
          {
              "defaultMessage": "Gender is required"
          },
          {
              "defaultMessage": "Last name cannot be blank"
          }
      ],
      "path": "/api/v1/patient/"
  }
  ```

### Update Patient

**Endpoint: PUT /patient/{id}**

- Description: Updates an existing patient based on its ID.

- Request (positive): PUT http://localhost:8080/api/v1/patient/c9ce156d-82bf-4dc3-8bbc-56003f2c8886

  ```json
  {
      "firstName": "Leila",
      "lastName": "Mizrahi-Reyes",
      "birthDate": "1980-01-02",
      "gender": "OTHER"
  }
  ```

- Response (positive): 200 OK

  ```json
  {
      "id": "c9ce156d-82bf-4dc3-8bbc-56003f2c8886",
      "firstName": "Leila",
      "lastName": "Mizrahi-Reyes",
      "birthDate": "1980-01-02",
      "gender": "OTHER",
      "feedbacks": []
  }
  ```

### Delete Patient By ID

**Endpoint: DELETE /patient/{id}**

- Description: Deletes a patient based on its ID.

- Request (positive): DELETE http://localhost:8080/api/v1/patient/c9ce156d-82bf-4dc3-8bbc-56003f2c8886

- Response (positive): 204 No Content

### List All Patient Feedbacks

**Endpoint: GET /patient/{id/feedback**

- Description: List all feedbacks for a patient based the patient ID.

- Request (positive): http://localhost:8080/api/v1/patient/b3db2be0-1b2f-45eb-8fc7-5c72fba379ab/feedback

- Response (positive): 200 OK

  ```json
  [
      {
          "id": "55d097dc-18eb-4bca-9bd0-63c26d0999e0",
          "patientId": "b3db2be0-1b2f-45eb-8fc7-5c72fba379ab",
          "npi": "1245319599",
          "rating": 8,
          "comment": "Very attentive doctor"
      },
      {
          "id": "d0367f4e-16a3-478a-ace9-d4c43248f5c8",
          "patientId": "b3db2be0-1b2f-45eb-8fc7-5c72fba379ab",
          "npi": "1245319588",
          "rating": 2,
          "comment": "Had to wait way too long"
      }
  ]
  ```

### Get Patient By ID

**Endpoint: GET /patient/{id}**

- Description: Retrieves a patient based on its ID.

- Request (positive): GET http://localhost:8080/api/v1/patient/b3db2be0-1b2f-45eb-8fc7-5c72fba379ab

- Response (positive): 200 OK

  ```json
  {
      "id": "b3db2be0-1b2f-45eb-8fc7-5c72fba379ab",
      "firstName": "Barbara",
      "lastName": "Zimmerman",
      "birthDate": "1964-03-06",
      "gender": "FEMALE",
      "feedbacks": [
          {
              "id": "55d097dc-18eb-4bca-9bd0-63c26d0999e0",
              "patientId": "b3db2be0-1b2f-45eb-8fc7-5c72fba379ab",
              "npi": "1245319599",
              "rating": 8,
              "comment": "Very attentive doctor"
          },
          {
              "id": "d0367f4e-16a3-478a-ace9-d4c43248f5c8",
              "patientId": "b3db2be0-1b2f-45eb-8fc7-5c72fba379ab",
              "npi": "1245319588",
              "rating": 2,
              "comment": "Had to wait way too long"
          }
      ]
  }
  ```

### List All Patients

**Endpoint: GET /patient/**

- Description: Retrieves all patients.

- Request: GET http://localhost:8080/api/v1/patient/

- Response: 200 OK

  ```json
  [
      {
          "id": "b3db2be0-1b2f-45eb-8fc7-5c72fba379ab",
          "firstName": "Barbara",
          "lastName": "Zimmerman",
          "birthDate": "1964-03-06",
          "gender": "FEMALE",
          "feedbacks": [
              {
                  "id": "55d097dc-18eb-4bca-9bd0-63c26d0999e0",
                  "patientId": "b3db2be0-1b2f-45eb-8fc7-5c72fba379ab",
                  "npi": "1245319599",
                  "rating": 8,
                  "comment": "Very attentive doctor"
              },
              {
                  "id": "d0367f4e-16a3-478a-ace9-d4c43248f5c8",
                  "patientId": "b3db2be0-1b2f-45eb-8fc7-5c72fba379ab",
                  "npi": "1245319588",
                  "rating": 2,
                  "comment": "Had to wait way too long"
              }
          ]
      }
  ]
  ```

### Delete All Patients

**Endpoint: DELETE /patient**

- Description: Deletes all patients.

- Request (positive): DELETE http://localhost:8080/api/v1/patient

- Response (positive): 204 No Content

----------

## Feedback

### Create Feedback

**Endpoint: POST /feedback/**

- Description: Creates a new feedback for a patient based on patient ID.

- Request (positive): POST http://localhost:8080/api/v1/feedback/

  ```json
  {
      "patientId": "b3db2be0-1b2f-45eb-8fc7-5c72fba379ab",
      "npi": "1245319577",
      "rating": 8,
      "comment": "Dr. Kelly was late"
  }
  ```

- Response (positive): 200 OK

  ```json
  {
      "id": "19e79a6b-e8a2-4ea2-a831-8dd18d5d76db",
      "patientId": "b3db2be0-1b2f-45eb-8fc7-5c72fba379ab",
      "npi": "1245319577",
      "rating": 8,
      "comment": "Dr. Kelly was late"
  }
  ```

- Request (negative): POST http://localhost:8080/api/v1/feedback/

  ```json
  {
  }
  ```

- Response (negative): 400 Bad Request

  ```json
  {
      "timestamp": "2021-08-24T03:39:37.721+00:00",
      "status": 400,
      "error": "Bad Request",
      "message": "Validation failed for object='feedbackDto'. Error count: 5",
      "errors": [
          {
              "defaultMessage": "Comment cannot be blank"
          },
          {
              "defaultMessage": "Patient ID is required"
          },
          {
              "defaultMessage": "Npi cannot be blank"
          },
          {
              "defaultMessage": "Npi is required"
          },
          {
              "defaultMessage": "Rating must be 1-10"
          }
      ],
      "path": "/api/v1/feedback/"
  }
  ```

### Update Feedback

**Endpoint: PUT /feedback/{id}**

- Description: Updates a feedback for a patient based on its ID.

- Request (positive): PUT http://localhost:8080/api/v1/feedback/19e79a6b-e8a2-4ea2-a831-8dd18d5d76db

  ```json
  {
      "patientId": "b3db2be0-1b2f-45eb-8fc7-5c72fba379ab",
      "npi": "1245319577",
      "rating": 8,
      "comment": "Dr. Kelly was late"
  }
  ```

- Response (positive): 200 OK

  ```json
  {
      "id": "19e79a6b-e8a2-4ea2-a831-8dd18d5d76db",
      "patientId": "b3db2be0-1b2f-45eb-8fc7-5c72fba379ab",
      "npi": "1245319577",
      "rating": 6,
      "comment": "Dr. Kelly was late and rude"
  }
  ```

### Delete Feedback By ID

**Endpoint: DELETE /feedback/{id}**

- Description: Deletes a feedback based on its ID.

- Request (positive): DELETE http://localhost:8080/api/v1/feedback/19e79a6b-e8a2-4ea2-a831-8dd18d5d76db

- Response (positive): 204 No Content

### Get Feedback By ID

**Endpoint: GET /feedback/{id}**

- Description: Retrieves a feedback based on its ID.

- Request (positive): GET http://localhost:8080/api/v1/feedback/d0367f4e-16a3-478a-ace9-d4c43248f5c8

- Response (positive): 200 OK

  ```json
  {
      "id": "d0367f4e-16a3-478a-ace9-d4c43248f5c8",
      "patientId": "b3db2be0-1b2f-45eb-8fc7-5c72fba379ab",
      "npi": "1245319588",
      "rating": 2,
      "comment": "Had to wait way too long"
  }
  ```

### List All Feedbacks

**Endpoint: GET /feedback/**

- Description: Lists all feedbacks for all patients.

- Request: GET http://localhost:8080/api/v1/feedback/

- Response: 200 OK

  ```json
  [
      {
          "id": "55d097dc-18eb-4bca-9bd0-63c26d0999e0",
          "patientId": "b3db2be0-1b2f-45eb-8fc7-5c72fba379ab",
          "npi": "1245319599",
          "rating": 8,
          "comment": "Very attentive doctor"
      },
      {
          "id": "d0367f4e-16a3-478a-ace9-d4c43248f5c8",
          "patientId": "b3db2be0-1b2f-45eb-8fc7-5c72fba379ab",
          "npi": "1245319588",
          "rating": 2,
          "comment": "Had to wait way too long"
      }
  ]
  ```

### Delete All Feedbacks

**Endpoint: DELETE /feedback**

- Description: Deletes all feedbacks.

- Request (positive): DELETE http://localhost:8080/api/v1/feedback

- Response (positive): 204 No Content

----------

## Address

### Create Address

**Endpoint: POST /address/**

- Description: Creates a new address.

- Request (positive): POST http://localhost:8080/api/v1/address/

  ```json
  {
      "use": "HOME",
      "line": "1069 Algonquin Ave",
      "line2": "Ste 3",
      "city": "Livermore",
      "state": "CA",
      "zip": "94551"
  }
  ```

- Response (positive): 200 OK

  ```json
  {
      "id": "c5e0fb9e-e192-4879-a2ed-2a10df015191",
      "use": "HOME",
      "line": "1069 Algonquin Ave",
      "line2": "Ste 3",
      "city": "Livermore",
      "state": "CA",
      "zip": "94551"
  }
  ```

- Request (negative): POST http://localhost:8080/api/v1/address/

  ```json
  {
  }
  ```

- Response (negative): 400 Bad Request

  ```json
  {
      "timestamp": "2021-08-24T03:41:19.384+00:00",
      "status": 400,
      "error": "Bad Request",
      "message": "Validation failed for object='addressDto'. Error count: 3",
      "errors": [
          {
              "defaultMessage": "Line is required"
          },
          {
              "defaultMessage": "Line cannot be blank"
          },
          {
              "defaultMessage": "Use is required"
          }
      ],
      "path": "/api/v1/address/"
  }
  ```

### Update Address

**Endpoint: PUT /address/{id}**

- Description: Updates an address based on its ID.

- Request (positive): PUT http://localhost:8080/api/v1/address/c5e0fb9e-e192-4879-a2ed-2a10df015191

  ```json
  {
      "use": "WORK",
      "line": "1810 Franklin Ave",
      "line2": "Unit 181",
      "city": "Seattle",
      "state": "WA",
      "zip": "98102"
  }
  ```

- Response (positive): 200 OK

  ```json
  {
      "id": "c5e0fb9e-e192-4879-a2ed-2a10df015191",
      "use": "WORK",
      "line": "1810 Franklin Ave",
      "line2": "Unit 181",
      "city": "Seattle",
      "state": "WA",
      "zip": "98102"
  }
  ```

### Delete Address By ID

**Endpoint: DELETE /address/{id}**

- Description: Deletes an address based on its ID.

- Request (positive): DELETE http://localhost:8080/api/v1/address/c2ba9e77-18d9-4a37-b76b-42e97620562a

- Response (positive): 204 No Content

### Get Address By ID

**Endpoint: GET /address/{id}**

- Request (positive): GET http://localhost:8080/api/v1/address/c5e0fb9e-e192-4879-a2ed-2a10df015191

- Response (positive): 200 OK

  ```json
  {
      "id": "c5e0fb9e-e192-4879-a2ed-2a10df015191",
      "use": "WORK",
      "line": "1810 Franklin Ave",
      "line2": "Unit 181",
      "city": "Seattle",
      "state": "WA",
      "zip": "98102"
  }
  ```
### List All Addresses

**Endpoint: GET /address/**

- Request: GET http://localhost:8080/api/v1/address/

- Response: 200 OK

  ```json
  [
      {
          "id": "c5e0fb9e-e192-4879-a2ed-2a10df015191",
          "use": "WORK",
          "line": "1810 Franklin Ave",
          "line2": "Unit 181",
          "city": "Seattle",
          "state": "WA",
          "zip": "98102"
      }
  ]
  ```

### Delete All Addresses

**Endpoint: DELETE /address**

- Description: Deletes all addresses.

- Request (positive): DELETE http://localhost:8080/api/v1/address

- Response (positive): 204 No Content
