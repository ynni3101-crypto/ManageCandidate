package model;

import java.util.ArrayList;
import java.util.List;

public class CandidateList {
    private List<Candidate> candidateList = new ArrayList<>();

    public void addCandidate(Candidate c) {
        candidateList.add(c);
    }

    public List<Candidate> getAllList() {
        return candidateList;
    }
    
    public List<Candidate> getByType(int type) {
        List<Candidate> result = new ArrayList<>();
        for (Candidate c : candidateList) {
            if (c.getCandidateType() == type)
               result.add(c);
        }
        return result;
    }
    
    public List<Candidate> search(String name, int type) {
        String key = name.toLowerCase();
        List<Candidate> result = new ArrayList<>();
        for (Candidate c : candidateList) {
            if ((c.getFirstName().toLowerCase().contains(key) || c.getLastName().toLowerCase().contains(key)) && c.getCandidateType() == type) {
               result.add(c);
            }
        }
        return result;
    }
}
