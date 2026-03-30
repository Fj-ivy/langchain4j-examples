---
name: test-skill
description: "Validates test fixtures and reference file loading by returning predefined content from bundled reference files. Use when verifying skill infrastructure, testing reference resolution, or checking that the skill engine correctly reads bundled resources."
---

## Workflow

1. **Load reference content** from [references/full.md](references/full.md) to retrieve the test payload.

2. **Return the content** to the caller as-is, confirming that reference file resolution works correctly.

**Validation:** The output should match the exact content of `references/full.md`. If `references/empty.md` is loaded instead, it should return an empty string — use this to verify empty-file handling.