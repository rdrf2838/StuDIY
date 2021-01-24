package com.example.studiy.ui.signup.test;

import androidx.lifecycle.ViewModel;

import com.example.studiy.classes.UninitialisedViewModelException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SignupViewModelTest extends ViewModel {
    static private SignupViewModelTest stvm;
    private List<String> questions = new ArrayList<>();
    private List<String> answers_a = new ArrayList<>();
    private List<String> answers_b = new ArrayList<>();
    private int[] answers_submitted;

    public int[] getAnswers_submitted() {
        return answers_submitted;
    }

    public boolean isFinished() {
        for (int i = 0; i < answers_submitted.length; i++)
            if (answers_submitted[i] == 0) return false;
        return true;
    }

    public int getProgress() {
        int ctr = 0;
        for (int i = 0; i < answers_submitted.length; i++) {
            if (answers_submitted[i] != 0) ctr++;
        }
        return ctr * 100 / answers_submitted.length;
    }

    public String getResult() {
        int E = 0, I = 0, S = 0, N = 0, T = 0, F = 0, J = 0, P = 0;
        for (int i = 0; i < answers_submitted.length; i++) {
            switch (i % 7) {
                case 1:
                    if (answers_submitted[i] == 1) E += 1;
                    break;
                case 2:
                    if (answers_submitted[i] == 1) S += 1;
                    break;
                case 3:
                    if (answers_submitted[i] == 1) S += 1;
                    break;
                case 4:
                    if (answers_submitted[i] == 1) T += 1;
                    break;
                case 5:
                    if (answers_submitted[i] == 1) T += 1;
                    break;
                case 6:
                    if (answers_submitted[i] == 1) J += 1;
                    break;
                case 7:
                    if (answers_submitted[i] == 1) J += 1;
                    break;
            }
        }
        I = 10 - E;
        N = 20 - S;
        F = 20 - T;
        P = 20 - J;
        return String.format("%c%c%c%c", (I > E ? 'I' : 'E'), (N > S ? 'N' : 'S'), (F > T ? 'F' : 'T'), (P > J ? 'P' : 'J'));
    }

    public static void setSTVM(SignupViewModelTest s) {
        stvm = s;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public List<String> getAnswers_a() {
        return answers_a;
    }

    public List<String> getAnswers_b() {
        return answers_b;
    }

    public SignupViewModelTest() {
        stvm = this;
        Scanner scanner = new Scanner(stuff);
        int i = 0;
        while (scanner.hasNextLine()) {
            if (i == 0) {
                questions.add(scanner.nextLine());
            } else if (i == 1) {
                answers_a.add(scanner.nextLine());
            } else if (i == 2) {
                answers_b.add(scanner.nextLine());
            }
            i = (i + 1) % 3;
        }
        answers_submitted = new int[questions.size()];
    }

    public static SignupViewModelTest getInstance() {
        if (stvm == null) throw new UninitialisedViewModelException("SignupTestViewModel");
        return stvm;
    }

    // Extremely cursed method of doing things
    String stuff = "1. At a party do you:\n" +
            "a. Interact with many, including strangers\n" +
            "b. Interact with a few, known to you\n" +
            "2. Are you more:\n" +
            "a. Realistic than speculative\n" +
            "b. Speculative than realistic\n" +
            "3. Is it worse to:\n" +
            "a. Have your “head in the clouds”\n" +
            "b. Be “in a rut”\n" +
            "4. Are you more impressed by:\n" +
            "a. Principles\n" +
            "b. Emotions\n" +
            "5. Are more drawn toward the:\n" +
            "a. Convincing\n" +
            "b. Touching\n" +
            "6. Do you prefer to work:\n" +
            "a. To deadlines\n" +
            "b. Just “whenever”\n" +
            "7. Do you tend to choose:\n" +
            "a. Rather carefully\n" +
            "b. Somewhat impulsively\n" +
            "8. At parties do you:\n" +
            "a. Stay late, with increasing energy\n" +
            "b. Leave early with decreased energy\n" +
            "9. Are you more attracted to:\n" +
            "a. Sensible people\n" +
            "b. Imaginative people\n" +
            "10. Are you more interested in:\n" +
            "a. What is actual\n" +
            "b. What is possible\n" +
            "11. In judging others are you more swayed by:\n" +
            "a. Laws than circumstances\n" +
            "b. Circumstances than laws\n" +
            "12. In approaching others is your inclination to be somewhat:\n" +
            "a. Objective\n" +
            "b. Personal\n" +
            "13. Are you more:\n" +
            "a. Punctual\n" +
            "b. Leisurely\n" +
            "14. Does it bother you more having things:\n" +
            "a. Incomplete\n" +
            "b. Completed\n" +
            "15. In your social groups do you:\n" +
            "a. Keep abreast of other’s happenings\n" +
            "b. Get behind on the news\n" +
            "16. In doing ordinary things are you more likely to:\n" +
            "a. Do it the usual way\n" +
            "b. Do it your own way\n" +
            "17. Writers should:\n" +
            "a. “Say what they mean and mean what they say”\n" +
            "b. Express things more by use of analogy\n" +
            "18. Which appeals to you more:\n" +
            "a. Consistency of thought\n" +
            "b. Harmonious human relationships\n" +
            "19. Are you more comfortable in making:\n" +
            "a. Logical judgments\n" +
            "b. Value judgments\n" +
            "20. Do you want things:\n" +
            "a. Settled and decided\n" +
            "b. Unsettled and undecided\n" +
            "21. Would you say you are more:\n" +
            "a. Serious and determined\n" +
            "b. Easy-going\n" +
            "22. In phoning do you:\n" +
            "a. Rarely question that it will all be said\n" +
            "b. Rehearse what you’ll say\n" +
            "23. Facts:\n" +
            "a. “Speak for themselves”\n" +
            "b. Illustrate principles\n" +
            "24. Are visionaries:\n" +
            "a. somewhat annoying\n" +
            "b. rather fascinating\n" +
            "25. Are you more often:\n" +
            "a. a cool-headed person\n" +
            "b. a warm-hearted person\n" +
            "26. Is it worse to be:\n" +
            "a. unjust\n" +
            "b. merciless \n" +
            "27. Should one usually let events occur:\n" +
            "a. by careful selection and choice\n" +
            "b. randomly and by chance\n" +
            "28. Do you feel better about:\n" +
            "a. having purchased\n" +
            "b. having the option to buy\n" +
            "29. In company do you:\n" +
            "a. initiate conversation\n" +
            "b. wait to be approached\n" +
            "30. Common sense is:\n" +
            "a. rarely questionable\n" +
            "b. frequently questionable\n" +
            "31. Children often do not:\n" +
            "a. make themselves useful enough\n" +
            "b. exercise their fantasy enough\n" +
            "32. In making decisions do you feel more comfortable with:\n" +
            "a. standards\n" +
            "b. feelings\n" +
            "33. Are you more:\n" +
            "a. firm than gentle\n" +
            "b. gentle than firm\n" +
            "34. Which is more admirable:\n" +
            "a. the ability to organize and be methodical\n" +
            "b. the ability to adapt and make do\n" +
            "35. Do you put more value on:\n" +
            "a. infinite\n" +
            "b. open-minded\n" +
            "36. Does new and non-routine interaction with others:\n" +
            "a. stimulate and energize you\n" +
            "b. tax your reserves\n" +
            "37. Are you more frequently:\n" +
            "a. a practical sort of person\n" +
            "b. a fanciful sort of person\n" +
            "38. Are you more likely to:\n" +
            "a. see how others are useful\n" +
            "b. see how others see\n" +
            "39. Which is more satisfying:\n" +
            "a. to discuss an issue thoroughly\n" +
            "b. to arrive at agreement on an issue\n" +
            "40. Which rules you more:\n" +
            "a. your head\n" +
            "b. your heart\n" +
            "41. Are you more comfortable with work that is:\n" +
            "a. contracted\n" +
            "b. done on a casual basis\n" +
            "42. Do you tend to look for:\n" +
            "a. the orderly\n" +
            "b. whatever turns up\n" +
            "43. Do you prefer:\n" +
            "a. many friends with brief contact\n" +
            "b. a few friends with more lengthy contact\n" +
            "44. Do you go more by:\n" +
            "a. facts\n" +
            "b. principles\n" +
            "45. Are you more interested in:\n" +
            "a. production and distribution\n" +
            "b. design and research\n" +
            "46. Which is more of a compliment:\n" +
            "a. “There is a very logical person.”\n" +
            "b. “There is a very sentimental person.”\n" +
            "47. Do you value in yourself more that you are:\n" +
            "a. unwavering\n" +
            "b. devoted\n" +
            "48. Do you more often prefer the\n" +
            "a. final and unalterable statement\n" +
            "b. tentative and preliminary statement\n" +
            "49. Are you more comfortable:\n" +
            "a. after a decision\n" +
            "b. before a decision\n" +
            "50. Do you:\n" +
            "a. speak easily and at length with strangers\n" +
            "b. find little to say to strangers\n" +
            "51. Are you more likely to trust your:\n" +
            "a. experience\n" +
            "b. hunch\n" +
            "52. Do you feel:\n" +
            "a. more practical than ingenious\n" +
            "b. more ingenious than practical\n" +
            "53. Which person is more to be complimented – one of:\n" +
            "a. clear reason\n" +
            "b. strong feeling \n" +
            "54. Are you inclined more to be:\n" +
            "a. fair-minded\n" +
            "b. sympathetic\n" +
            "55. Is it preferable mostly to:\n" +
            "a. make sure things are arranged\n" +
            "b. just let things happen\n" +
            "56. In relationships should most things be:\n" +
            "a. re-negotiable\n" +
            "b. random and circumstantial\n" +
            "57. When the phone rings do you:\n" +
            "a. hasten to get to it first\n" +
            "b. hope someone else will answer\n" +
            "58. Do you prize more in yourself:\n" +
            "a. a strong sense of reality\n" +
            "b. a vivid imagination\n" +
            "59. Are you drawn more to:\n" +
            "a. fundamentals\n" +
            "b. overtones\n" +
            "60. Which seems the greater error:\n" +
            "a. to be too passionate\n" +
            "b. to be too objective\n" +
            "61. Do you see yourself as basically:\n" +
            "a. hard-headed\n" +
            "b. soft-hearted\n" +
            "62. Which situation appeals to you more:\n" +
            "a. the structured and scheduled\n" +
            "b. the unstructured and unscheduled\n" +
            "63. Are you a person that is more:\n" +
            "a. routinized than whimsical\n" +
            "b. whimsical than routinized\n" +
            "64. Are you more inclined to be:\n" +
            "a. easy to approach\n" +
            "b. somewhat reserved\n" +
            "65. In writings do you prefer:\n" +
            "a. the more literal\n" +
            "b. the more figurative\n" +
            "66. Is it harder for you to:\n" +
            "a. identify with others\n" +
            "b. utilize others\n" +
            "67. Which do you wish more for yourself:\n" +
            "a. clarity of reason\n" +
            "b. strength of compassion\n" +
            "68. Which is the greater fault:\n" +
            "a. being indiscriminate\n" +
            "b. being critical\n" +
            "69. Do you prefer the:\n" +
            "a. planned event\n" +
            "b. unplanned event\n" +
            "70. Do you tend to be more:\n" +
            "a. deliberate than spontaneous\n" +
            "b. spontaneous than deliberate";
}
