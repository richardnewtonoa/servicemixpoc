package com.kirona.helpers.jm;

import org.springframework.stereotype.Component;

import com.kirona.schemas.jobmanager.jm.model.ActionCreateArray;
import com.kirona.schemas.jobmanager.jm.model.AssetCreateArray;
import com.kirona.schemas.jobmanager.jm.model.AttributeValueCreateArray;
import com.kirona.schemas.jobmanager.jm.model.CreateJobRequest;
import com.kirona.schemas.jobmanager.jm.model.GetJobResponse;
import com.kirona.schemas.jobmanager.jm.model.JobCreate;
import com.kirona.schemas.jobmanager.jm.model.JobLocationCreateArray;
import com.kirona.schemas.jobmanager.jm.model.JobNoteInput;
import com.kirona.schemas.jobmanager.jm.model.JobNoteInputArray;
import com.kirona.schemas.jobmanager.jm.model.JobNoteOutput;
import com.kirona.schemas.jobmanager.jm.model.JobPartyCreateArray;
import com.kirona.schemas.jobmanager.jm.model.JobSchedulingCriteriaCreate;

@Component
public class JobHelperImpl implements JobHelper {

  @Override
  public JobCopyBuilder copyJob(GetJobResponse source) {
    return copyJob(source, defaultJobCopy(source));
  }

  private CreateJobRequest defaultJobCopy(GetJobResponse source) {
    CreateJobRequest j = new CreateJobRequest();
    j.setJobTypeCode(source.getJobTypeCode());
    j.setNotes(defaultCopyNotes(source));
    j.setFixedAttributes(defaultCopyFixedAttributes(source));
    // TODO : copy more stuff
    return j;
  }

  private JobCreate defaultCopyFixedAttributes(GetJobResponse source) {
    JobCreate jc = new JobCreate();
    jc.setDescription(source.getFixedAttributes().getDescription());
    jc.setExternalRef1(source.getFixedAttributes().getExternalRef1());
    jc.setExternalRef2(source.getFixedAttributes().getExternalRef2());
    jc.setReportedDateTime(source.getFixedAttributes().getReportedDateTime());
    // TODO : copy more stuff
    return jc;
  }

  private JobNoteInputArray defaultCopyNotes(GetJobResponse source) {
    
    final JobNoteInputArray notes = new JobNoteInputArray();
    
    if ((source.getNotes() != null) && (source.getNotes().getJobNote() != null)) {
      source.getNotes().getJobNote().forEach(sourceNote -> {
        JobNoteInput newNote = defaultCopyNote(sourceNote);
        if (newNote != null) {
          notes.getJobNote().add(newNote);
        }
      });
    }

    return notes;
  }

  private JobNoteInput defaultCopyNote(JobNoteOutput sourceNote) {
    if (sourceNote == null) { return null; }
    
    JobNoteInput newNote = new JobNoteInput();
    
    newNote.setFormattedNote(sourceNote.getFormattedNote());
    newNote.setNote(sourceNote.getNote());
    return newNote;
  }

  @Override
  public JobCopyBuilder copyJob(GetJobResponse source, CreateJobRequest target) {
    JobCopyBuilder b = new JobCopyBuilder();
    b.source = source;
    b.target = defaultRequiredFields(target);
    return b;
  }

  private CreateJobRequest defaultRequiredFields(CreateJobRequest r) {
    // there are lots of stupid required list container elements in create job
    if (r.getActions() == null) {
      r.setActions(new ActionCreateArray());
    }
    if (r.getAssets() == null) {
      r.setAssets(new AssetCreateArray());
    }
    if (r.getExtensibleAttributes() == null) {
      r.setExtensibleAttributes(new AttributeValueCreateArray());
    }
    if (r.getFixedAttributes() == null) {
      r.setFixedAttributes(new JobCreate());
    }
    if (r.getFixedAttributes().getSchedulingCriteria() == null) {
      r.getFixedAttributes().setSchedulingCriteria(new JobSchedulingCriteriaCreate());
    }
    if (r.getLocations() == null) {
      r.setLocations(new JobLocationCreateArray());
    }
    if (r.getNotes() == null) {
      r.setNotes(new JobNoteInputArray());
    }
    if (r.getParties() == null) {
      r.setParties(new JobPartyCreateArray());
    }
    return r;
  }

}
