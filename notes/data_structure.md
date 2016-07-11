# The Data Structures of DAG

## `Node` `abstract`
```javascript
{
    "id": "string",
    "description": "string",
    "dependencies": ["list of Nodes"],
    "dependents": ["list of Nodes"]
}
```

A `Node` is the fundamental building block of all DAGs. It describes the basics of all structures, namely that for any structure, there is a unique `id`, a list of Nodes upon which the current `Node` depends, and a list of Nodes which depend on the current `Node`.

In the event of an empty `dependencies` list, this `Node` is known as an `entryPoint` for its containing structure.  If the `dependents` list is empty, then it is known as an `exitPoint` for its containing structure.

## `Task` `extends` `Node`
```javascript
{
    "type": "Task",
    "contexts": ["list of contexts"],
    "completed": "boolean"
}
```

A `Task` is the *atomic* `Node` type. It has no `entryPoints` nor `exitPoints` and it is the only `Node` with context and completability. All other composite structures implicitly have context and completability from their contained `Tasks`.  The concept of a `context` is derived from the idea that a `Task` is to be completed in the real world in a certain place or situation. Many real work activities can be done in multiple situations or contexts, so DAG `Tasks` are polycontextual.

## `Track` `extends` `Node`
```javascript
{
    "type": "Track",
    "entryPoint": "Node",
    "exitPoint": "Node"
}
```

A `Track` represents the concept of a sequence of dependent tasks. `Tracks` are not immune to branching, but their philosophy is to keep parallel tracks isolated from one another.  It also allows for common sequences of events to be easily manipulated and rescheduled within the greater DAG.

## `Phase` `extends` `Node`
```javascript
{
    "type": "Phase",
    "entryPoint": ["list of Nodes"],
    "exitPoint": "Node"
}
```

A `Phase` represents the idea of a dependency bottleneck or checkpoint. It differs from the philosophy of a Track in that it allows several parallel `Nodes` to synchronize before progress continues.  Therefore, it has only one `exitPoint`.

## `Project` `extends` `Node`
```javascript
{
    "type": "Project",
    "entryPoints": ["list of Nodes"],
    "exitPoints": ["list of Nodes"]
}
```

A `Project` is meant to be the largest unit of a DAG containing `Phases` and `Tracks`.  However, since it is a `Node`, a `Project` can be dependent on another `Project`.  `Tracks` of `Projects` can be made. A `Project` can have multiple goals, or `exitPoints`, and therefore produce cross-dependencies between `Tracks` and `Phases`.
