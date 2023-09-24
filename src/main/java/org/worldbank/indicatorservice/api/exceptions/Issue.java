package org.worldbank.indicatorservice.api.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;

@JsonInclude(Include.NON_NULL)
public class Issue extends IssueParent {

  private IssueDescription description;
  private List<String> details;

  public Issue() {
  }

  public Issue(final IssueEnum issue) {
    super(issue);
  }

  public Issue(final IssueEnum issue, final Object... args) {
    super(issue, args);
  }

  public Issue(final IssueEnum issue, final List<String> details) {
    this(issue);
    this.details = details;
  }

  public List<String> getDetails() {
    return details;
  }

  public void setDetails(List<String> details) {
    this.details = details;
  }

  public IssueDescription getDescription() {
    return description;
  }

  public void setDescription(final IssueDescription description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return String.format(
        "Issue{code= %s, message='%s' description= '%s'}",
        super.getCode(), super.getMessage(), description);
  }
}
