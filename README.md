# StuDIY

## Frontend
<img src="app_architecture.png" width="520">

I referred to [Google Jetpack](https://developer.android.com/jetpack/guide) for their guidelines on how to organise an app. This application follows the [Model-view viewmodel](https://www.wikiwand.com/en/Model%E2%80%93view%E2%80%93viewmodel) architectural pattern, where a ViewModel object acts as a wrapper to parse Models into Views, and vice-versa. Each component is only linked to the components above and below it to increase encapsulation. 

<img src="app_flows.png" width="520">

I split the app into 4 main flows, with each flow representing an action a user can take, e.g. logging in or signing up. This gives the app natural transitions between actions and continuity while performing the same action.

<img src="signup_flow.png" width="520">

Each flow comprises an activity, its fragments, as well as the necessary viewmodels for managing the data. All transitions between fragments are managed within the activity class while layout changes are managed by each fragment, which separates the fragment design from the app transition logic. One problem I ran into is that Recycler Adapters couldn't access the viewmodel properly so I had to use a singleton pattern for the viewmodel (I'm not sure if this is the best approach though).

## Backend
### Relational Model
I implemented the following relational model as shown in the ER diagram below. In particular, we store a person's personality (MBTI), interests, and subject scores, which are the primary features used by the ML model to calculate compatibility scores. 

<img src="er_model.png" width="520">

I did not have time to integrate the database into the frontend, but I would have had the ML model calculate compatibility scores locally, on each person's phone. This is because every time a user adds new information (e.g. more test scores), we need to recalculate scores, and it makes sense to distribute the computation instead of having centralised computation on a server.
### Machine Learning Model
I created a simple Keras model to predict the compatibility scores between tutors and tutees. 
As seen in ipnyb file, the features used are:
Input | Description
------------ | -------------
8 | Signed difference between tutor/tutee scores
4 | Similarity between tutor/tutee MBTI
4 | Similarity between tutor/tutee interests/activities

And the outputs are:
Output | Description
------------ | -------------
8 | Compatibility score for each subject

I don't think there's available data specific to this use-case so I wasn't able to pre-train with real data; instead I wrote some test data. In theory, we can easily use the ratings between tutor and tutee as reliable labels for the data. I also didn't have time to integrate the model into the backend, but there are libraries like [DeepLearning4j](https://deeplearning4j.org/) which I plan to use.
