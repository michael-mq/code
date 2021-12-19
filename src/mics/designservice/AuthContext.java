package mics.designservice;

import java.util.List;

/** Identifies the caller of a service method. */
class AuthContext {
  public final String userId;

  AuthContext(String userId) {
    this.userId = userId;
  }
}

interface DesignService {
  /** Creates a design and returns the design id. */
  String createDesign(AuthContext ctx, String designContent);

  /** Returns the design content, if the user has access to the design. */
  String getDesign(AuthContext ctx, String designId);

  /** Returns a list of design ids that the given context has access to. */
  List<String> findDesigns(AuthContext ctx);

  /** Gives a specific user access to the design. */
  void shareDesign(AuthContext ctx, String designId, String targetUserId);
}
