package controller;

import model.CandidateList;
import view.ConsoleForm;
import view.DataInput;
import view.Menu;

public class CandidateManage {
    private CandidateList list = new CandidateList();
    private ConsoleForm form = new ConsoleForm();

    public void execute() {
        while (true) {
            int choice = Menu.getChoice();
            switch (choice) {
                case 1:
                    do { list.addCandidate(form.inputExperience()); }
                    while (DataInput.inputYesNo());
                    form.displayAllList(list.getAllList());
                    break;
                case 2:
                    do { list.addCandidate(form.inputFresher()); }
                    while (DataInput.inputYesNo());
                    form.displayAllList(list.getAllList());
                    break;
                case 3:
                    do { list.addCandidate(form.inputIntern()); }
                    while (DataInput.inputYesNo());
                    form.displayAllList(list.getAllList());
                    break;
                case 4: 
                    form.searchCandidates(list);
                    break;
                case 5:
                    return;
                
            }
        }
    }
}
