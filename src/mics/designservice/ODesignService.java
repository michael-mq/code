package mics.designservice;

import java.util.*;

public class ODesignService implements DesignService {
    private Map<String, Map<UUID, String>> designStore;
    private Map<String, Set<UUID>> permissionStore;

    public ODesignService(Map<String, Map<UUID, String>> designStore, Map<String, Set<UUID>> permissionStore) {
        this.designStore = designStore;
        this.permissionStore = permissionStore;
    }

    @Override
    public String createDesign(AuthContext ctx, String designContent) {
        String userId = ctx.userId;

        Map<UUID, String> designs = designStore.computeIfAbsent(userId, k -> new HashMap<>());

        UUID designId = UUID.randomUUID();

        designs.put(designId, designContent);

        Set<UUID> permissions = permissionStore.computeIfAbsent(userId, k -> new HashSet<>());

        permissions.add(designId);

        return designId.toString();
    }

    @Override
    public String getDesign(AuthContext ctx, String designId) throws RuntimeException {
        String userId = ctx.userId;

        if (!designStore.containsKey(userId)) {
            throw new RuntimeException("User not exiting");
        }

        Map<UUID, String> designs = designStore.get(userId);

        UUID designIDUUID = UUID.fromString(designId);

        if (!designs.containsKey(designIDUUID)) {
            throw new RuntimeException("designID not existing");
        }

        return designs.get(designIDUUID);
    }


    @Override
    public List<String> findDesigns(AuthContext ctx) throws RuntimeException{
        String userId = ctx.userId;

        if (!designStore.containsKey(userId)) {
            throw new RuntimeException("User not exiting");
        }

        Map<UUID, String> designs = designStore.get(userId);

        List<String> result = new ArrayList<>();

        for (Map.Entry entry : designs.entrySet()) {
            result.add(entry.getKey().toString());
        }

        return result;
    }

    @Override
    public void shareDesign(AuthContext ctx, String designId, String targetUserId)  throws RuntimeException {
        String userId = ctx.userId;

        if (!designStore.containsKey(userId)) {
            throw new RuntimeException("User not exiting");
        }

        Map<UUID, String> designs = designStore.get(userId);

        UUID designIDUUID = UUID.fromString(designId);

        if (!designs.containsKey(designIDUUID)) {
            throw new RuntimeException("designID not existing");
        }

        Set<UUID> permissions = permissionStore.computeIfAbsent(targetUserId, k -> new HashSet<>());

        permissions.add(designIDUUID);
    }
}
