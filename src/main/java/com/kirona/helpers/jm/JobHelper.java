package com.kirona.helpers.jm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import com.kirona.schemas.jobmanager.jm.model.CreateJobRequest;
import com.kirona.schemas.jobmanager.jm.model.GetJobResponse;
import com.kirona.schemas.jobmanager.jm.model.JobLineGet;

public interface JobHelper {

  public static class JobLineMapper {
    final JobCopyBuilder builder;
    String fromType;
    String toType;
    Predicate<JobLineGet> whichLines = (l)->true; // all lines by default
    final Map<String,String> attributeCodeMap = new HashMap<>(); // empty means all attributes
    
    private JobLineMapper(JobCopyBuilder builder) {
      this.builder = builder;
    }
    
    public JobCopyBuilder add() {
      return builder.mapJobLines(this);
    }
    
    public JobLineMapper to(String lineType) {
      toType = lineType;
      return this;
    }
    
    public JobLineMapper where(Predicate<JobLineGet> predicate) {
      whichLines = predicate;
      return this;
    }
    
    public JobLineMapper mapAttribute(String from, String to) {
      attributeCodeMap.put(from, to);
      return this;
    }
  }
  
  public static class JobCopyBuilder {
    CreateJobRequest target;
    GetJobResponse source;
    final Map<String,String> attributeCodeMap = new HashMap<>();  // empty means all attributes
    final List<JobLineMapper> jobLineMappers = new ArrayList<>(); // empty means NO job lines
    
    public JobCopyBuilder mapAttribute(String from, String to) {
      attributeCodeMap.put(from, to);
      return this;
    }
    
    public JobLineMapper lineMapper(String fromType) {
      JobLineMapper m = new JobLineMapper(this);
      m.fromType = fromType;
      m.toType = fromType;
      return m;
    }
    
    public JobCopyBuilder mapJobLines(JobLineMapper mapper) {
      jobLineMappers.add(mapper);
      return this;
    }

    public CreateJobRequest performMap() {
      mapAttributes();
      mapJobLines();
      return target;
    }

    private void mapJobLines() {
      // TODO Auto-generated method stub
      
    }

    private void mapAttributes() {
      // TODO Auto-generated method stub
      
    }
  }

  public static boolean hasAttributeValue(JobLineGet line, String attributeCode, String value) {
    // TODO : not implemented
    return true;
  }
  
  public JobCopyBuilder copyJob(GetJobResponse source);
  
  public JobCopyBuilder copyJob(GetJobResponse source, CreateJobRequest target);
}
